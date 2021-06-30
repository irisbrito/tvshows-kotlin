package com.br.iris.core.mapper

import com.br.iris.core.model.Serie
import com.br.iris.database.entity.SerieEntity
import com.br.iris.infrastructure.model.SerieEvent

class SerieConverter {
    companion object {
        fun serieEventToSerie(serieEvent: SerieEvent) =
            Serie(serieEvent.id, serieEvent.name, serieEvent.description, serieEvent.genre, serieEvent.whereToWatch)
        fun serieToSerieEvent(serie: Serie) =
            SerieEvent(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
        fun serieToSerieEntity(serie: Serie) =
            SerieEntity(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
        fun serieEntityToSerie(serieEntity: SerieEntity) =
            Serie(serieEntity.id, serieEntity.name, serieEntity.description, serieEntity.genre, serieEntity.whereToWatch)
    }
}
