package com.br.iris.util

import com.br.iris.entity.Serie

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