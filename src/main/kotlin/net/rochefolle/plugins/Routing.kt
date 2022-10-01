package net.rochefolle.plugins

import net.rochefolle.routes.deviceInformationRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*
import net.rochefolle.routes.swaggerRoute

object RoutingConfig {
    const val version = "/v1"
}
fun Application.configureRouting() {
    routing {
        deviceInformationRouting()
        swaggerRoute()
    }
}
