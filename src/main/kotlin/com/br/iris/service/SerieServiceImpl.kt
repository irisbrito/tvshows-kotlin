package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import javax.inject.Inject

class SerieServiceImpl @Inject constructor(private var serieRepository: SerieRepository)
    : SerieService {

    override fun create(series: Serie): Serie {
       return serieRepository.save(series)
    }

    override fun getById(id: Long): Serie? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long) {
        TODO("Not yet implemented")
    }

    override fun update(id: Long): Serie {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Serie> {
        TODO("Not yet implemented")
    }

}