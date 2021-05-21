package com.br.iris.entity

import javax.persistence.*

@Entity
data class Serie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column
        var name: String,
        @Column
        var description: String,
        @Column
        var genre: String,
        @Column
        var whereToWatch: String,
) {
    constructor(): this(null,"","","", "")
}
