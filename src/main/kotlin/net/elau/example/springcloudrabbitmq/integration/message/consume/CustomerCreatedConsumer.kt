package net.elau.example.springcloudrabbitmq.integration.message.consume

import net.elau.example.springcloudrabbitmq.exception.InvalidDataException
import net.elau.example.springcloudrabbitmq.integration.message.event.CustomerCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class CustomerCreatedConsumer {
    companion object {
        private val log = LoggerFactory.getLogger(CustomerCreatedConsumer::class.java)
    }

    @Bean("customer-created-consumer")
    fun consume() = Consumer<CustomerCreatedEvent> { customerCreatedEvent ->
        log.debug("m=accept, msg=Consumed event={}", customerCreatedEvent)

        customerCreatedEvent.runCatching { document.toLong() }
            .onFailure {
                throw InvalidDataException("Invalid document param sent to create customer [$customerCreatedEvent]")
            }

        throw RuntimeException("Retryable exception...")
    }
}