package com.br.iris.service

import com.br.iris.entity.Serie
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val cqlSession: CqlSession)
    : SerieService {

    override fun create(serie: Serie): Serie {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO tv-shows.Serie(id,name,description,genre,where_to_watch) VALUES (?,?,?,?,?)",
                    UUID.randomUUID(),
                    serie.name,
                    serie.description,
                    serie.genre,
                    serie.whereToWatch
                )
        )
        return serie;
    }

    /*override fun getAll(): List<Serie> {
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
   }*/

}