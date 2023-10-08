package net.elau.example.springcloudrabbitmq.dto

data class CreateCustomerDTO(
    val firstName: String,
    val lastName: String,
    val document: String,
    val email: String
)
