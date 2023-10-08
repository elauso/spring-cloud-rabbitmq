package net.elau.example.springcloudrabbitmq.web.request

data class CreateCustomerRequest(
    val firstName: String,
    val lastName: String,
    val document: String,
    val email: String
)
