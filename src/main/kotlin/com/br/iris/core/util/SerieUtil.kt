package com.br.iris.core.util

import com.br.iris.core.model.Serie

class SerieUtil {
    companion object{
        fun nameValid(serie: Serie): Serie {
            if(serie.name.isNullOrEmpty()) {
                throw Exception("Nome inválido")
            }
            return serie
        }
    }

}