package com.br.iris.broker

import com.br.iris.core.model.Serie
import com.br.iris.core.service.SerieServiceImpl
import com.br.iris.infrastructure.broker.SerieListener
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieListenerTest : AnnotationSpec() {

    val service = mockk<SerieServiceImpl>(relaxed = true)
    val serieListener = SerieListener(service)
    lateinit var serie: Serie

    @BeforeEach
    fun setUp() {
        serie = Serie(UUID.randomUUID(), "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should receive and save serie`(){
        every { service.create(any()) } returns serie
        val result = serieListener.receive(serie)
        result shouldBe Unit
    }
}