package metadata.repository

import metadata.model.TicketFromMetadata
import ticket.model.TicketId

interface MetaDataTicketRepository {

    fun listTickets(): List<TicketFromMetadata>
    fun getTicket(id: TicketId): TicketFromMetadata?
}