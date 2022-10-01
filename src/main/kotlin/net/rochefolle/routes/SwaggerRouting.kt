package net.rochefolle.routes

import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Route.swaggerRoute() {
    static("/static") {
        resources("files")
        resource("/", "files/index.html")
    }
}