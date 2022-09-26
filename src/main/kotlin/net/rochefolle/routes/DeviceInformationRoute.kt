package net.rochefolle.routes

import net.rochefolle.models.DeviceInformation
import net.rochefolle.models.DeviceSignature
import net.rochefolle.models.DeviceType
import net.rochefolle.models.deviceInformationStorage
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deviceInformationRouting() {
    route("/deviceInformation") {
        post {
            val deviceInformation = call.receive<DeviceInformation>()
            deviceInformationStorage.add(deviceInformation)
            val deviceInformationWithSignature = DeviceInformation(
                deviceInformation.url,
                deviceInformation.userAgent,
                deviceInformation.whiteListedCookies,
                deviceInformation.ipAddress,
                deviceInformation.sessionId,
                DeviceSignature("9876543210", 1),
                DeviceType(true, false, true, true)
            )
            call.respond(deviceInformationWithSignature)
        }
    }
}