package com.br.iris.repository

import com.br.iris.core.mapper.SerieConverter
import com.br.iris.core.model.Serie
import com.br.iris.database.repository.SerieRepositoryImpl
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import java.util.*

class SerieRepositoryTest : AnnotationSpec() {
    val cqlSession = mockk<CqlSession>(relaxed = true)
    val serieRepositoryImpl = SerieRepositoryImpl(cqlSession)
    lateinit var serie: Serie
    val id : UUID = UUID.fromString("0e337aaf-2458-4ff8-9116-84492b8d29b1")

    @BeforeEach
    fun setUp() {
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should save a serie`() {
        val queryResult =   cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO tv_shows.Series(id,name,description,genre,where_to_watch) VALUES (?,?,?,?,?)",
                    UUID.randomUUID(),
                    serie.name,
                    serie.description,
                    serie.genre,
                    serie.whereToWatch
                )
        )

       val result = SerieConverter.serieEntityToSerie(serieRepositoryImpl.create(serie))
        result shouldBe serie
    }

    @Test
    fun `should delete a serie`(){
        cqlSession.execute(
                SimpleStatement
                        .newInstance(
                                "DELETE FROM tv_shows.Series WHERE id = ?",
                                id
                        )
        )

        val result = serieRepositoryImpl.delete(id)
        result shouldBe Unit
    }

    @Test
    fun `should update a serie`(){
        cqlSession.execute(
                SimpleStatement
                        .newInstance(
                                "UPDATE tv_shows.Series SET name = ?, description = ?, genre = ?, where_to_watch = ? WHERE id = ?",
                                serie.name,
                                serie.description,
                                serie.genre,
                                serie.whereToWatch,
                                serie.id
                        )
        )

        val result = SerieConverter.serieEntityToSerie(serieRepositoryImpl.update(id, serie))
        result shouldBe serie
    }

    @Test
    fun `should get all series`(){
        val queryResult = cqlSession.execute(
                SimpleStatement
                        .newInstance(
                                "SELECT * FROM tv_shows.Series",
                        )
        )
        val listOfSeries = queryResult.map { serie ->
            Serie(
                    serie.getUuid("id")!!,
                    serie.getString("name")!!,
                    serie.getString("description")!!,
                    serie.getString("genre")!!,
                    serie.getString("where_to_watch")!!
            )
        }.toList()

        val result = serieRepositoryImpl.getAll()

        result shouldBe listOfSeries
    }

}