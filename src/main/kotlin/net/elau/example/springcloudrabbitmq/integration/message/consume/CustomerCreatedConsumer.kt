package net.elau.example.springcloudrabbitmq.integration.message.consume

import mu.KotlinLogging
import net.elau.example.springcloudrabbitmq.exception.InvalidDataException
import net.elau.example.springcloudrabbitmq.integration.message.event.CustomerCreatedEvent
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class CustomerCreatedConsumer {

    private val logger = KotlinLogging.logger {}

    @Bean("customer-created-consumer")
    fun consume() = Consumer<CustomerCreatedEvent> { customerCreatedEvent ->
        logger.debug { "m=consume, msg=Consumed event=$customerCreatedEvent" }
        customerCreatedEvent.runCatching { document.toLong() }
            .onFailure {
                val exception =
                    InvalidDataException("Invalid document param sent to create customer [$customerCreatedEvent]")
                logger.error(exception) {
                    "m=consume, error=Failed to consume event=[$customerCreatedEvent]"
                }
                throw exception
            }.getOrThrow()
    }
}
