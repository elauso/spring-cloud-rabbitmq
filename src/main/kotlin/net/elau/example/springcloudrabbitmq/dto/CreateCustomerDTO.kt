package net.elau.example.springcloudrabbitmq.dto

data class CreateCustomerDTO(
    val firstname: String,
    val lastName: String,
    val document: String,
    val email: String
)
