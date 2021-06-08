package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepository: SerieRepository) : SerieService {

    override fun create(serie: Serie): Serie {
       return serieRepository.create(serie)
    }

    override fun getAll(): List<Serie> {
        return serieRepository.getAll()
    }

    override fun getById(id: UUID): Serie? {
       return serieRepository.getById(id)
    }

    override fun delete(id: UUID) {
        return serieRepository.delete(id)
    }

    override fun update(id: UUID, serie: Serie): Serie {
        TODO("Not yet implemented")
    }

}