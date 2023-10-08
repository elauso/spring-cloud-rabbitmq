package net.elau.example.springcloudrabbitmq.mapper

import net.elau.example.springcloudrabbitmq.dto.CreateCustomerDTO
import net.elau.example.springcloudrabbitmq.dto.CustomerDTO
import net.elau.example.springcloudrabbitmq.integration.message.event.CustomerCreatedEvent
import net.elau.example.springcloudrabbitmq.web.request.CreateCustomerRequest
import java.util.*

fun CreateCustomerRequest.toDTO() = CreateCustomerDTO(
    firstName = firstName,
    lastName = lastName,
    document = document,
    email = email
)

fun CreateCustomerDTO.toDTO() = CustomerDTO(
    id = UUID.randomUUID(),
    firstName = firstName,
    lastName = lastName,
    document = document,
    email = email
)

fun CustomerDTO.toEvent() = CustomerCreatedEvent(
    id = id,
    firstName = firstName,
    lastName = lastName,
    document = document,
    email = email
)