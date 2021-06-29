package com.br.iris.core.port

import com.br.iris.core.model.Serie
import com.br.iris.database.entity.SerieEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieRepository {
    fun create(serie: Serie): SerieEntity
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
    fun delete(id: UUID)
    fun update(id: UUID, serie: Serie): SerieEntity
}