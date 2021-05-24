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
        serie = Serie(1L, "name", "description","genre", "netflix")
    }

    @Test
    fun `should create serie`(){
        every {service.create(any()) } answers {serie}
        val result = serieController.addSerie(serie).body()
        result shouldBe serie
    }

}

