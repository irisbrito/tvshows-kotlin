package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieServiceTest : AnnotationSpec() {

    val repository = mockk<SerieRepository>(relaxed = true)
    val serieService = SerieServiceImpl(repository)
    lateinit var serie : Serie

    @BeforeEach
    fun setUp(){
        serie = Serie(UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338"), "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should save serie`(){
        every {repository.create(any()) } answers {serie}
        val result = serieService.create(serie)
        result shouldBe serie
    }
/*
    @Test
    fun `should get serie by id`(){
        every {repository.findById(any())} answers {Optional.of(serie)}
        val result = serieService.getById(1L)
        result shouldBe serie
    }*/

   /* @Test
    fun `should delete serie`(){
        every { repository.existsById(any()) } answers  {true}
        every { repository.deleteById(any()) } answers  {Unit}
        val result = serieService.delete(1L)
        result shouldBe Unit
    }*/
}