package net.rochefolle.routes

import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import net.rochefolle.plugins.RoutingConfig

object SwaggerRouteConfig {
    private const val route: String = "/swagger"
    const val path: String = "${RoutingConfig.version}/${route}"
}

fun Route.swaggerRoute() {
    static(SwaggerRouteConfig.path) {
        resources("files/swagger-ui")
        resource("/", "files/swagger-ui/index.html")
        resource("/swagger.json", "files/swagger.json")
    }
}