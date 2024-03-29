package net.elau.example.springcloudrabbitmq.dto

import java.util.*

data class CustomerDTO(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val document: String,
    val email: String
)