package net.rochefolle.plugins

import net.rochefolle.routes.deviceInformationRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        deviceInformationRouting()
    }
}
