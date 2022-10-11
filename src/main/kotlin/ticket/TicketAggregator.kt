package ticket

import metadata.model.TicketFromMetadata
import metadata.repository.MetaDataTicketRepository
import ticket.model.Ticket
import ticket.model.TicketId
import ticketing.model.TicketFromTicketing
import ticketing.repository.TicketingTicketRepository
import java.time.LocalDate

data class TicketAggregator(
    val metadataTicketRepository: MetaDataTicketRepository,
    val ticketingTicketRepository: TicketingTicketRepository
) {
    fun listTickets(): List<Ticket> {
        val tickets = mutableListOf<Ticket>()

        metadataTicketRepository.listTickets().map { ticketFromMetadata ->
            ticketingTicketRepository.listTickets().map { ticketFromTicketing ->
                if (ticketFromTicketing.id == ticketFromMetadata.id) {
                    tickets.add(aggregateTicketFrom(ticketFromMetadata, ticketFromTicketing))
                }
            }
        }
        return tickets
    }

    fun getTicket(id: TicketId) = listTickets().first { id == it.id }

    fun listDatedTickets() = listTickets().filter { ticket ->
        LocalDate.now().isAfter(ticket.validityStartDate) && LocalDate.now().isBefore(ticket.validityEndDate)
    }

    fun listUndatedTickets() = listTickets().filter { ticket -> LocalDate.now().isAfter(ticket.validityEndDate) }

    fun listValidTickets(date: LocalDate) =
        listTickets().filter { date.isAfter(it.validityStartDate) && date.isBefore(it.validityEndDate) }

    private fun aggregateTicketFrom(
        ticketFromMetadata: TicketFromMetadata,
        ticketFromTicketing: TicketFromTicketing
    ): Ticket {
        return Ticket(
            id = ticketFromMetadata.id,
            price = ticketFromTicketing.price,
            label = ticketFromMetadata.label,
            conditions = ticketFromMetadata.conditions,
            description = ticketFromMetadata.description,
            isDated = ticketFromTicketing.isDated,
            validityStartDate = ticketFromTicketing.validityStartDate,
            validityEndDate = ticketFromTicketing.validityEndDate
        )
    }
}