package net.rochefolle.models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceSignature(val signature: String, val version: Int)