package net.rochefolle.routes

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class SwaggerRouteTest {

    @Test
    fun `get index from static content`() = testApplication {
        val response = client.get("${SwaggerRouteConfig.path}/index.html")

        assertEquals(response.status, HttpStatusCode.OK)
    }
    @Test
    fun `get default from static content`() = testApplication {
        val response = client.get("${SwaggerRouteConfig.path}/")

        assertEquals(response.status, HttpStatusCode.OK)
    }
}