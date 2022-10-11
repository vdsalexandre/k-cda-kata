package ticketing.repository

import ticket.model.TicketId
import ticketing.model.TicketFromTicketing

interface TicketingTicketRepository {

    fun listTickets(): List<TicketFromTicketing>
    fun getTicket(id: TicketId): TicketFromTicketing?
}