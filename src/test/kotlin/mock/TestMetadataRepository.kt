package mock

import factory.DataTicketFactory.metaTicketFute
import factory.DataTicketFactory.metaTicketGaulois
import factory.DataTicketFactory.metaTicketLiberte
import metadata.model.TicketFromMetadata
import metadata.repository.MetaDataTicketRepository
import ticket.model.TicketId

class TestMetadataRepository : MetaDataTicketRepository {

    override fun listTickets(): List<TicketFromMetadata> {
        return listOf(
            metaTicketGaulois,
            metaTicketFute,
            metaTicketLiberte
        )
    }

    override fun getTicket(id: TicketId): TicketFromMetadata? {
        return listTickets().find { ticket -> ticket.id == id }
    }
}