package net.elau.example.springcloudrabbitmq.integration.message.produce

import mu.KotlinLogging
import net.elau.example.springcloudrabbitmq.dto.CustomerDTO
import net.elau.example.springcloudrabbitmq.mapper.toEvent
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CustomerCreatedProducer(private val streamBridge: StreamBridge) {

    private val logger = KotlinLogging.logger {}

    fun produce(customerDTO: CustomerDTO) {
        logger.debug { "m=produce, msg=Producing created customer event=$customerDTO" }
        streamBridge.send("customer-created-producer-out-0", MessageBuilder.withPayload(customerDTO.toEvent()).build())
    }
}