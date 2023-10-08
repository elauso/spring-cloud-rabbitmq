package net.elau.example.springcloudrabbitmq.integration.message.produce

import net.elau.example.springcloudrabbitmq.dto.CustomerDTO
import net.elau.example.springcloudrabbitmq.mapper.toEvent
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class CustomerCreatedProducer(private val streamBridge: StreamBridge) {

    fun produce(customerDTO: CustomerDTO) {
        val message = MessageBuilder.withPayload(customerDTO.toEvent()).build()
        streamBridge.send("customer-created-producer-out-0", message)
    }
}