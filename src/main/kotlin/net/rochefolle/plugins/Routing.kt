package net.rochefolle.plugins

import net.rochefolle.routes.deviceInformationRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*
import net.rochefolle.routes.swaggerRoute

fun Application.configureRouting() {
    routing {
        deviceInformationRouting()
        swaggerRoute()
    }
}
