package com.br.iris.entity

import java.util.*

data class Serie(
        val id: UUID?,
        var name: String,
        var description: String,
        var genre: String,
        var whereToWatch: String,
) {
    constructor(): this(null,"","","", "")
}
