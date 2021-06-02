package com.br.iris.entity

data class Serie(
        val id: Long?,
        var name: String,
        var description: String,
        var genre: String,
        var whereToWatch: String,
) {
    constructor(): this(null,"","","", "")
}
