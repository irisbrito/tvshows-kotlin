package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class SerieServiceTest : AnnotationSpec() {

    val repository = mockk<SerieRepository>()
    val serieService = SerieServiceImpl(repository)
    lateinit var serie : Serie

    @BeforeEach
    fun setUp(){
        serie = Serie(1L, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

}