package net.rochefolle.routes

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class SwaggerRouteTest {

    @Test
    fun `get index from static content`() = testApplication {
        val response = client.get("/static/index.html")

        assertEquals(response.status, HttpStatusCode.OK)
    }
    @Test
    fun `get default from static content`() = testApplication {
        val response = client.get("/static/")

        assertEquals(response.status, HttpStatusCode.OK)
    }
}