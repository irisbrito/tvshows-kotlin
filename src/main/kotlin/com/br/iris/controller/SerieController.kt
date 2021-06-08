package com.br.iris.controller

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import com.br.iris.service.SerieService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("series/")
class SerieController(private val serieRepository: SerieRepository) {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    fun addSerie(@Body series: Serie): HttpResponse<Serie?> {
        return HttpResponse.created(HttpStatus.CREATED).body(this.serieRepository.create(series))
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSeries(): HttpResponse<List<Serie?>>{
        return HttpResponse.ok(HttpStatus.OK).body(this.serieRepository.getAll())
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSerieById(@PathVariable id:UUID): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(this.serieRepository.getById(id))
    }

    @Put("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateSerie(@PathVariable id:UUID, @Body serie: Serie): HttpResponse<Serie>{
        return HttpResponse.ok(HttpStatus.OK).body(serieRepository.update(id, serie))
    }

    @Delete("/{id}")
    fun deleteSerie(@PathVariable id:UUID) {
        serieRepository.delete(id)
    }

}