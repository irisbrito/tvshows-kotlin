package com.br.iris.core.mapper

import com.br.iris.core.model.Serie
import com.br.iris.database.entity.SerieEntity
import com.br.iris.entrypoint.dto.SerieDto

class SerieConverter {
    companion object {
        fun serieDtoToSerie(serieDto: SerieDto) =
            Serie(serieDto.id, serieDto.name, serieDto.description, serieDto.genre, serieDto.whereToWatch)
        fun serieToSerieDto(serie: Serie) =
            SerieDto(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
        fun serieToSerieEntity(serie: Serie) =
            SerieEntity(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
        fun serieEntityToSerie(serieEntity: SerieEntity) =
            Serie(serieEntity.id, serieEntity.name, serieEntity.description, serieEntity.genre, serieEntity.whereToWatch)
    }
}
