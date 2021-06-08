package com.br.iris.entity

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class Serie(
        val id: UUID? = null,
        var name: String = "",
        var description: String = "",
        var genre: String = "",
        var whereToWatch: String = "",
)