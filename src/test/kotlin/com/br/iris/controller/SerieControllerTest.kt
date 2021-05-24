package com.br.iris.controller

import com.br.iris.entity.Serie
import com.br.iris.service.SerieService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk
import io.mockk.every

@MicronautTest
class SerieControllerTest : AnnotationSpec() {

    val service = mockk<SerieService>()
    val serieController = SerieController(service)
    lateinit var serie : Serie

    @BeforeEach
    fun setUp(){
        serie = Serie(1L, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should create serie`(){
        every {service.create(any()) } answers {serie}
        val result = serieController.addSerie(serie).body()
        result shouldBe serie
    }

    @Test
    fun `should get serie by id`(){
        every {service.getById(any())} answers {serie}
        val result = serieController.getSerieById(1L).body()
        result shouldBe serie
    }

    @Test
    fun `should delete serie`(){
        every {service.delete(any())} answers {Unit}
        val result = serieController.deleteSerie(1L)
        result shouldBe Unit
    }

    @Test
    fun `should update serie`(){
        every {service.update(any(), any())} answers {serie}
        val result = serieController.updateSerie(1L, serie).body()
        result shouldBe serie
    }

    @Test
    fun `should get all series`(){
        every {service.getAll()} answers {listOf(serie)}
        val result = serieController.getSeries().body()
        result shouldBe listOf(serie)
    }
}

