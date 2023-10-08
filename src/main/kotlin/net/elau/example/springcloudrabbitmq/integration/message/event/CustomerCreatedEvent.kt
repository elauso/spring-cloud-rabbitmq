package net.elau.example.springcloudrabbitmq.integration.message.event

import java.util.*

data class CustomerCreatedEvent(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val document: String,
    val email: String
)
