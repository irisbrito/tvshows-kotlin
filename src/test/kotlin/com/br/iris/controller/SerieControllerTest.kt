package com.br.iris.controller
/*
import com.br.iris.core.model.Serie
import com.br.iris.core.port.SerieService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk
import io.mockk.every
import java.util.*

@MicronautTest
class SerieControllerTest : AnnotationSpec() {

    val service = mockk<SerieService>()
    val serieController = SerieController(service)
    lateinit var serie : Serie
    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")


    @BeforeEach
    fun setUp(){
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
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
        val result = serieController.getSerieById(id).body()
        result shouldBe serie
    }

    @Test
    fun `should delete serie`(){
        every {service.delete(any())} answers {Unit}
        val result = serieController.deleteSerie(id)
        result shouldBe Unit
    }

    @Test
    fun `should update serie`(){
        every {service.update(any(), any())} answers {serie}
        val result = serieController.updateSerie(id, serie).body()
        result shouldBe serie
    }

    @Test
    fun `should get all series`(){
        every {service.getAll()} answers {listOf(serie)}
        val result = serieController.getSeries().body()
        result shouldBe listOf(serie)
    }
}

*/