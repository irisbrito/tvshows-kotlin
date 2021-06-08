package com.br.iris.controller

import com.br.iris.entity.Serie
import com.br.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("series/")
class SerieController(private val serieService: SerieService) {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun addSerie(@Body series: Serie): HttpResponse<Serie?> {
        return HttpResponse.created(HttpStatus.CREATED).body(this.serieService.create(series))
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSeries(): HttpResponse<List<Serie?>>{
        return HttpResponse.ok(HttpStatus.OK).body(this.serieService.getAll())
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSerieById(@PathVariable id:UUID): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(this.serieService.getById(id))
    }

    @Put("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateSerie(@PathVariable id:UUID, @Body serie: Serie): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(serieService.update(id, serie))
    }

    @Delete("/{id}")
    fun deleteSerie(@PathVariable id:UUID) {
        serieService.delete(id)
    }

}