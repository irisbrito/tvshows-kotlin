package com.br.iris.exception

import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton

@Produces
@Singleton
@Requires(classes = [SerieNotFoundException::class, ExceptionHandler::class])
class ExceptionHandler : ExceptionHandler<SerieNotFoundException?, HttpResponse<*>>  {

    override fun handle(request: HttpRequest<*>?, exception: SerieNotFoundException?): HttpResponse<*> {
        val errorMessage = ErrorMessage(
            HttpStatus.BAD_REQUEST.toString(),
            400,"invalid arguments")

        return HttpResponse.badRequest(errorMessage)
    }
}