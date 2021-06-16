package com.br.iris.broker

import com.br.iris.entity.Serie
import com.br.iris.service.SerieServiceImpl
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class SerieListener(private val serieService: SerieServiceImpl) {

    @Subject("series")
    fun receive(@Body serie: Serie) {
        serieService.create(serie)
        println("Got serie - $serie")
    }
}