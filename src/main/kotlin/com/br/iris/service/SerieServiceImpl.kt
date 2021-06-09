package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepository: SerieRepository) : SerieService {

    override fun create(serie: Serie): Serie = serieRepository.create(serie)

    override fun getAll(): List<Serie> = serieRepository.getAll()

    override fun getById(id: UUID): Serie? = serieRepository.getById(id)

    override fun delete(id: UUID) = serieRepository.delete(id)

    override fun update(id: UUID, serie: Serie): Serie = serieRepository.update(id, serie)
}