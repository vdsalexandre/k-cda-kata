package metadata.model

import ticket.model.TicketId

data class TicketFromMetadata(
    val id: TicketId,
    val label: String,
    val conditions: String,
    val description: String
)
