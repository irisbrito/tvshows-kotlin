package com.br.iris.core.service

import com.br.iris.core.mapper.SerieConverter
import com.br.iris.core.model.Serie
import com.br.iris.core.port.SerieRepositoryPort
import com.br.iris.core.port.SerieServicePort
import java.util.UUID
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepositoryPort: SerieRepositoryPort) : SerieServicePort {

    override fun create(serie: Serie): Serie =
      SerieConverter.serieEntityToSerie(serieRepositoryPort.create(serie))

    override fun getAll(): List<Serie> = serieRepositoryPort.getAll()

    override fun getById(id: UUID): Serie? = serieRepositoryPort.getById(id)

    override fun delete(id: UUID) = serieRepositoryPort.delete(id)

    override fun update(id: UUID, serie: Serie): Serie =
      SerieConverter.serieEntityToSerie(serieRepositoryPort.update(id, serie))

}