package com.br.iris.service

import com.br.iris.entity.Serie
import io.micronaut.data.annotation.Query
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun create(series: Serie): Serie
    fun getAll(): List<Serie>
    fun getById(id: Long): Serie?
    fun delete(id: Long)
    fun update(id: Long, serie: Serie): Serie
}