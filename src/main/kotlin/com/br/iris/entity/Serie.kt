package com.br.iris.entity

import javax.persistence.*

@Entity
data class Serie(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @Column
        val name: String,
        @Column
        val description: String,
        @Column
        val genre: String,
        @Column
        val whereToWatch: String,
) {
    constructor(): this(null,"","","", "")
}
