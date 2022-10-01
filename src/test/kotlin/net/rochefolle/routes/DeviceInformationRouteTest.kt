package net.rochefolle.routes

import net.rochefolle.models.DeviceInformation
import net.rochefolle.models.DeviceInformationBuilder.Companion.defaultDeviceInformation
import net.rochefolle.models.DeviceInformationBuilder.Companion.minimalDeviceInformation
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class DeviceInformationRouteTest {

    @Test
    fun `Retrieve DeviceInformation signature`() = testApplication {
        val httpClient = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val deviceInformation = defaultDeviceInformation()

        val response = httpClient.post(DeviceInformationRouteConfig.path) {
            contentType(ContentType.Application.Json)
            setBody(deviceInformation)
        }
        val responseDeviceInformation = response.body<DeviceInformation>()
        assertEquals(
            responseDeviceInformation.url, deviceInformation.url
        )
        assertNotNull(
            responseDeviceInformation.deviceSignature
        )
        assertNotNull(
            responseDeviceInformation.deviceType
        )
        assertEquals(
            1, responseDeviceInformation.deviceSignature!!.version
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }


    @Test
    fun `Retrieve partial DeviceInformation signature`() = testApplication {
        val httpClient = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val deviceInformation = minimalDeviceInformation()

        val response = httpClient.post(DeviceInformationRouteConfig.path) {
            setBody(deviceInformation)
            headers["Content-Type"] = "application/json"
        }
        val responseDeviceInformation = response.body<DeviceInformation>()
        assertEquals(
            responseDeviceInformation.url, deviceInformation.url
        )
        assertNotNull(
            responseDeviceInformation.deviceSignature
        )
        assertNotNull(
            responseDeviceInformation.deviceType
        )
        assertEquals(
            1, responseDeviceInformation.deviceSignature!!.version
        )
        assertEquals(HttpStatusCode.OK, response.status)
    }
}