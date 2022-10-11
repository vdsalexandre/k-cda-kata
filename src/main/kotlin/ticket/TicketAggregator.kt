package ticket

import metadata.repository.MetaDataTicketRepository
import ticketing.repository.TicketingTicketRepository

data class TicketAggregator(
    val metadataTicketRepository: MetaDataTicketRepository,
    val ticketingTicketRepository: TicketingTicketRepository
) {
}