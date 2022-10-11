package ticketing.model

import ticket.model.TicketId
import ticket.model.Price
import java.time.LocalDate

data class TicketFromTicketing(
    val id: TicketId,
    val price: Price,
    val isDated: Boolean,
    val validityStartDate: LocalDate,
    val validityEndDate: LocalDate
)
