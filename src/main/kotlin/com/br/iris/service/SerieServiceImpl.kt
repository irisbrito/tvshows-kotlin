package com.br.iris.service

import com.br.iris.entity.Serie
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val cqlSession: CqlSession)
    : SerieService {

    private val LOG : Logger = LoggerFactory.getLogger(SerieService::class.java)

    override fun create(serie: Serie): Serie {
        cqlSession.execute(
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
        LOG.info("serie saved successfully {}")
        return serie
    }

    override fun getAll(): List<Serie> {
      val queryResult =  cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series",
                )
        )
        return queryResult.map { serie -> Serie(
            serie.getUuid("id") ,
            serie.getString("name") ?: "no name",
            serie.getString("description") ?: "no description",
            serie.getString("genre") ?: "no genre",
            serie.getString("where_to_watch") ?: "no local indicated to watch",
        ) }.toList()

    }

    override fun getById(id: Long): Serie {
       val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM tv_shows.Series WHERE id= ?",
                    id,
                    )
        )

       return queryResult.map { serie -> Serie(
            serie.getUuid("id")!!,
            serie.getString("name") ?: "no name",
            serie.getString("description") ?: "no description",
            serie.getString("genre") ?: "no genre",
            serie.getString("where_to_watch") ?: "no local indicated to watch",
        ) }.single()
    }

    override fun delete(id: Long) {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "DELETE FROM tv_shows.Series WHERE id = ?",
                    id
                )
        )
        LOG.info("serie deleted successfully {}")
    }

    override fun update(id: Long, serie: Serie): Serie {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE from tv_shows.Series SET name = ?, description = ?, genre = ?, where_to_watch = ? WHERE id = ?",
                    serie.id,
                    serie.name,
                    serie.description,
                    serie.genre,
                    serie.whereToWatch
                )
        )
        LOG.info("serie updated successfully {}")
        return serie

    }

}