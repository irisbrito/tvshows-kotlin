package com.br.iris.service

import com.br.iris.core.mapper.SerieConverter
import com.br.iris.core.model.Serie
import com.br.iris.core.port.SerieRepositoryPort
import com.br.iris.core.service.SerieServiceImpl
import com.br.iris.database.entity.SerieEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieServiceTest : AnnotationSpec() {

    val repository = mockk<SerieRepositoryPort>(relaxed = true)
    val serieService = SerieServiceImpl(repository)
    lateinit var serie : SerieEntity
    lateinit var serieModel : Serie
    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")

    @BeforeEach
    fun setUp(){
        serie = SerieEntity(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
        serieModel = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should save serie`(){
        every {repository.create(any()) } answers {serie}
        val result = serieService.create(serieModel)
        result shouldBe serieModel
    }

    @Test
    fun `should get serie by id`(){
        every {repository.getById(any())} answers {serieModel}
        val serieResult = SerieConverter.serieEntityToSerie(serie)
        val result = serieService.getById(id)
        result shouldBe serieResult
    }

   @Test
    fun `should delete serie`(){
        every { repository.delete(any()) } answers  {Unit}
        val result = serieService.delete(id)
        result shouldBe Unit
    }

    @Test
    fun `should update serie`(){
        every {repository.update(any(), any())} answers {serie}
        val result = SerieConverter.serieToSerieEntity(serieService.update(id, SerieConverter.serieEntityToSerie(serie)))
        result shouldBe serie
    }
}