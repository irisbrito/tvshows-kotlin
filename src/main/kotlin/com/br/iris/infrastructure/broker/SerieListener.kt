package com.br.iris.infrastructure.broker

import com.br.iris.core.model.Serie
import com.br.iris.core.service.SerieServiceImpl
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory

@NatsListener
class SerieListener(private val serieService: SerieServiceImpl) {

    private val logger = LoggerFactory.getLogger(SerieListener::class.java)

    @Subject("series")
    fun receive(serie: Serie) {
        serieService.create(serie)
        logger.info("msg recebida")
        println("Got serie - $serie")
    }
}