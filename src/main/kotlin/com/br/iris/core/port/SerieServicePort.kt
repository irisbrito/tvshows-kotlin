package com.br.iris.core.port

import com.br.iris.core.model.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieServicePort {
    fun create(serie: Serie): Serie
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
    fun delete(id: UUID)
    fun update(id: UUID, serie: Serie): Serie
}