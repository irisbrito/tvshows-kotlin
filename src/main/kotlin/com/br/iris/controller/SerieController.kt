package com.br.iris.controller

import com.br.iris.entity.Serie
import com.br.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("series/")
class SerieController(private val service: SerieService) {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun addSerie(@Body series: Serie): HttpResponse<Serie?> {
        return HttpResponse.created(HttpStatus.CREATED).body(this.service.create(series))
    }
}