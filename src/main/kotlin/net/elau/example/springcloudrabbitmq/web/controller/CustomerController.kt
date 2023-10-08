package net.elau.example.springcloudrabbitmq.web.controller

import net.elau.example.springcloudrabbitmq.mapper.toDTO
import net.elau.example.springcloudrabbitmq.service.CustomerService
import net.elau.example.springcloudrabbitmq.web.request.CreateCustomerRequest
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(CREATED)
    fun create(@RequestBody createCustomerRequest: CreateCustomerRequest) =
        customerService.create(createCustomerRequest.toDTO())
}