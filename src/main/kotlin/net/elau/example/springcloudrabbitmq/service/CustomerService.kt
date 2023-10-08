package net.elau.example.springcloudrabbitmq.service

import net.elau.example.springcloudrabbitmq.dto.CreateCustomerDTO
import net.elau.example.springcloudrabbitmq.integration.message.produce.CustomerCreatedProducer
import net.elau.example.springcloudrabbitmq.mapper.toDTO
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerCreatedProducer: CustomerCreatedProducer) {

    fun create(createCustomerDTO: CreateCustomerDTO) {
        customerCreatedProducer.produce(createCustomerDTO.toDTO())
    }
}