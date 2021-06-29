package com.br.iris.core.service

import com.br.iris.core.mapper.SerieConverter
import com.br.iris.core.model.Serie
import com.br.iris.core.port.SerieRepository
import com.br.iris.core.port.SerieService
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepository: SerieRepository) : SerieService {

    override fun create(serie: Serie): Serie =
      SerieConverter.serieEntityToSerie(serieRepository.create(serie))

    override fun getAll(): List<Serie> = serieRepository.getAll()

    override fun getById(id: UUID): Serie? = serieRepository.getById(id)

    override fun delete(id: UUID) = serieRepository.delete(id)

    override fun update(id: UUID, serie: Serie): Serie =
      SerieConverter.serieEntityToSerie(serieRepository.update(id, serie))

}