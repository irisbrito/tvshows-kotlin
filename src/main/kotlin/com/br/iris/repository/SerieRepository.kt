package com.br.iris.repository

import com.br.iris.entity.Serie
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface SerieRepository : JpaRepository<Serie,Long> {
}