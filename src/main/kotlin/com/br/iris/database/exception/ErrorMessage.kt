package com.br.iris.exception

data class ErrorMessage (
    val error: String = "",
    val code: Int = 0,
    val message: String = ""
)
