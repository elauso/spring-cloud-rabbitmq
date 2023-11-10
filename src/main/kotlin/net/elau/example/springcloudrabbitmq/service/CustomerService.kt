package net.elau.example.springcloudrabbitmq.service

import mu.KotlinLogging
import net.elau.example.springcloudrabbitmq.dto.CreateCustomerDTO
import net.elau.example.springcloudrabbitmq.integration.message.produce.CustomerCreatedProducer
import net.elau.example.springcloudrabbitmq.mapper.toDTO
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerCreatedProducer: CustomerCreatedProducer) {

    private val logger = KotlinLogging.logger {}

    fun create(createCustomerDTO: CreateCustomerDTO) {
        logger.debug { "m=create, msg=Creating customer service dto=$createCustomerDTO" }
        customerCreatedProducer.produce(createCustomerDTO.toDTO())
    }
}