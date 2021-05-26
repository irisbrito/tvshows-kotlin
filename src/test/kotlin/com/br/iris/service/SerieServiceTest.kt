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

    val repository = mockk<SerieRepository>()
    val serieService = SerieServiceImpl(repository)
    lateinit var serie : Serie

    @BeforeEach
    fun setUp(){
        serie = Serie(1L, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should save serie`(){
        every {repository.save(any()) } answers {serie}
        val result = serieService.create(serie)
        result shouldBe serie
    }

    @Test
    fun `should get serie by id`(){
        every {repository.findById(any())} answers {Optional.of(serie)}
        val result = serieService.getById(1L)
        result shouldBe serie
    }
}