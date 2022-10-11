package ticket.model

import java.time.LocalDate

data class Ticket(
    val id: TicketId,
    val price: Price,
    val label: String,
    val conditions: String,
    val description: String,
    val isDated: Boolean,
    val validityStartDate: LocalDate,
    val validityEndDate: LocalDate
)
