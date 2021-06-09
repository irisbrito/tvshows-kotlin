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
    val id : String = "3a5fd8cc-96a5-4603-8de9-3a333fa28338"

    @BeforeEach
    fun setUp(){
        serie = Serie(UUID.fromString(id), "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should save serie`(){
        every {repository.create(any()) } answers {serie}
        val result = serieService.create(serie)
        result shouldBe serie
    }

    @Test
    fun `should get serie by id`(){
        every {repository.getById(any())} answers {serie}
        val result = serieService.getById(UUID.fromString(id))
        result shouldBe serie
    }

   @Test
    fun `should delete serie`(){
        every { repository.delete(any()) } answers  {Unit}
        val result = serieService.delete(UUID.fromString(id))
        result shouldBe Unit
    }
}