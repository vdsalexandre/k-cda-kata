package mock

import factory.DataTicketFactory.ticketingTicketFute
import factory.DataTicketFactory.ticketingTicketGaulois
import factory.DataTicketFactory.ticketingTicketLiberte
import ticket.model.TicketId
import ticketing.model.TicketFromTicketing
import ticketing.repository.TicketingTicketRepository

class MockTicketingRepository : TicketingTicketRepository {
    override fun listTickets(): List<TicketFromTicketing> {
        return listOf(
            ticketingTicketGaulois,
            ticketingTicketFute,
            ticketingTicketLiberte
        )
    }

    override fun getTicket(id: TicketId): TicketFromTicketing? {
        return listTickets().find { ticket -> ticket.id == id }
    }
}