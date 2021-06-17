package com.br.iris.broker

import com.br.iris.entity.Serie
import com.br.iris.service.SerieServiceImpl
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