package com.br.iris.controller

import com.br.iris.entity.Serie
import com.br.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("series/")
class SerieController(private val service: SerieService) {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun addSerie(@Body series: Serie): HttpResponse<Serie?> {
        return HttpResponse.created(HttpStatus.CREATED).body(this.service.create(series))
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSeries(): HttpResponse<List<Serie?>>{
        return HttpResponse.ok(HttpStatus.CREATED).body(this.service.getAll())
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSerieById(@PathVariable id:Long): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(this.service.getById(id))
    }

    @Put("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateSerie(@PathVariable id:Long, @Body serie: Serie): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(service.update(id, serie))
    }

    @Delete("/{id}")
    fun deleteSerie(@PathVariable id:Long) {
         service.delete(id)
    }

}