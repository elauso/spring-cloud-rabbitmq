package net.elau.example.springcloudrabbitmq.web.request

data class CreateCustomerRequest(
    val firstname: String,
    val lastName: String,
    val document: String,
    val email: String
)
