package net.rochefolle.models

class DeviceInformationBuilder {
    companion object {
        /**
         * Prepare some builder functions in case needed for testing
        val withUrl: DeviceInformation.(String) -> DeviceInformation = { value ->
            DeviceInformation(
                value,
                this.userAgent,
                this.whiteListedCookies,
                this.ipAddress,
                this.sessionId,
                this.deviceSignature,
                this.deviceType
            )
            this
        }

        val withUserAgent: DeviceInformation.(String) -> DeviceInformation = { value ->
            DeviceInformation(
                this.url,
                value,
                this.whiteListedCookies,
                this.ipAddress,
                this.sessionId,
                this.deviceSignature,
                this.deviceType
            )
            this
        }

        val withCookies: DeviceInformation.(HashMap<String, String>) -> DeviceInformation = { value ->
            DeviceInformation(
                this.url,
                this.userAgent,
                value,
                this.ipAddress,
                this.sessionId,
                this.deviceSignature,
                this.deviceType
            )
            this
        }

        val withoutCookies: DeviceInformation.() -> DeviceInformation = {
            this.withCookies(HashMap())
        }

        val withIpAddress: DeviceInformation.(String?) -> DeviceInformation = { value ->
            DeviceInformation(
                this.url,
                this.userAgent,
                this.whiteListedCookies,
                value,
                this.sessionId,
                this.deviceSignature,
                this.deviceType
            )
            this
        }

        val withoutIpAddress: DeviceInformation.() -> DeviceInformation = {
            this.withIpAddress(null)
        }

        val withSessionId: DeviceInformation.(String?) -> DeviceInformation = { value ->
            DeviceInformation(
                this.url,
                this.userAgent,
                this.whiteListedCookies,
                this.ipAddress,
                value,
                this.deviceSignature,
                this.deviceType
            )
            this
        }

        val withoutSessionId: DeviceInformation.() -> DeviceInformation = {
            this.withSessionId(null)
        }
        */
        fun minimalDeviceInformation(): DeviceInformation {
            return DeviceInformation(
                "https://dotproperty.co.th",
                "User Agent",
            )
        }

        fun defaultDeviceInformation(): DeviceInformation {
            val cookies = HashMap<String, String>()
            cookies["cookies1"] = "value 1"
            cookies["cookies2"] = "value 2"
            return DeviceInformation(
                "https://dotproperty.co.th", "User Agent", cookies, "192.168.1.1", "123456789"
            )
        }

    }
}