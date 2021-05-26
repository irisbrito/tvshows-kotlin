package com.br.iris.service

import com.br.iris.entity.Serie
import com.br.iris.repository.SerieRepository
import java.util.*
import javax.inject.Inject
import kotlin.Exception

class SerieServiceImpl(private var serieRepository: SerieRepository)
    : SerieService {

    override fun create(series: Serie): Serie {
       return serieRepository.save(series)
    }

    override fun getAll(): List<Serie> {
        return serieRepository.findAll()
    }

    override fun getById(id: Long): Serie {
        val serie = serieRepository.findById(id)

        if(serie.isPresent){
            return serie.get()
        }

        throw Exception("Série não encontrada")
    }

    override fun delete(id: Long) {
        if(serieRepository.existsById(id)){
            serieRepository.deleteById(id)
        } else {
            throw Exception("Série não encontrada")
        }
    }

   override fun update(id: Long, serie: Serie): Serie {
       val serieInBD: Optional<Serie> = serieRepository.findById(id)

       if (serieInBD.isPresent) {
           val serieToUpdate = serieInBD.get()
           serieToUpdate.name = serie.name
           serieToUpdate.description = serie.description
           serieToUpdate.genre = serie.genre
           serieToUpdate.whereToWatch = serie.whereToWatch

           return serieRepository.update(serieToUpdate)

       } else {
           throw Exception("Série não encontrada")
       }
   }

}