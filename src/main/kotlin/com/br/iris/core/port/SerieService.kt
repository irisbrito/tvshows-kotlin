package com.br.iris.service

import com.br.iris.entity.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun create(serie: Serie): Serie
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
    fun delete(id: UUID)
    fun update(id: UUID, serie: Serie): Serie
}