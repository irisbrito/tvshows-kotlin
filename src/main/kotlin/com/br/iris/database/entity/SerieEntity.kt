package com.br.iris.database.entity

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class SerieEntity(
    val id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var genre: String = "",
    var whereToWatch: String = "",
)
