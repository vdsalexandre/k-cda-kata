package factory

import metadata.model.TicketFromMetadata
import ticket.model.Price
import ticket.model.Ticket
import ticket.model.TicketId
import ticketing.model.TicketFromTicketing
import java.math.BigDecimal.valueOf
import java.time.LocalDate
import java.util.Currency

object DataTicketFactory {

    val metaTicketGaulois = TicketFromMetadata(
        id = TicketId("GAULOIS"),
        label = "Le billet gaulois",
        conditions = "Choisir une date",
        description = "ce billet permet de venir au Parc à une date donnée"
    )

    val metaTicketFute = TicketFromMetadata(
        id = TicketId("FUTE"),
        label = "Le billet futé",
        conditions = "Valable toute l'année sauf noël et halloween",
        description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, sous conditions"
    )

    val metaTicketLiberte = TicketFromMetadata(
        id = TicketId("LIBERTE"),
        label = "Le billet liberté",
        conditions = "Valable toute l'année même noël et halloween",
        description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, même les jours de fête"
    )

    val ticketingTicketGaulois = TicketFromTicketing(
        id = TicketId("GAULOIS"),
        price = Price(value = valueOf(40), currency = Currency.getInstance("EUR"), valueOf(4)),
        isDated = true,
        validityStartDate = LocalDate.of(2022, 1, 1),
        validityEndDate = LocalDate.of(2022, 12, 31)
    )

    val ticketingTicketFute = TicketFromTicketing(
        id = TicketId("FUTE"),
        price = Price(value = valueOf(50), currency = Currency.getInstance("EUR"), valueOf(5)),
        isDated = true,
        validityStartDate = LocalDate.of(2021, 1, 1),
        validityEndDate = LocalDate.of(2021, 12, 31)
    )

    val ticketingTicketLiberte = TicketFromTicketing(
        id = TicketId("LIBERTE"),
        price = Price(value = valueOf(60), currency = Currency.getInstance("EUR"), valueOf(6)),
        isDated = true,
        validityStartDate = LocalDate.of(2022, 1, 1),
        validityEndDate = LocalDate.of(2022, 12, 31)
    )

    fun getTicketList(): List<Ticket> {
        return listOf(
            getTicketGaulois(),
            getTicketFute(),
            getTicketLiberte()
        )
    }

    fun getTicketGaulois(): Ticket {
        return Ticket(
            id = TicketId("GAULOIS"),
            price = Price(value = valueOf(40), currency = Currency.getInstance("EUR"), valueOf(4)),
            label = "Le billet gaulois",
            conditions = "Choisir une date",
            description = "ce billet permet de venir au Parc à une date donnée",
            isDated = true,
            validityStartDate = LocalDate.of(2022, 1, 1),
            validityEndDate = LocalDate.of(2022, 12, 31)
        )
    }

    fun getTicketFute(): Ticket {
        return Ticket(
            id = TicketId("FUTE"),
            price = Price(value = valueOf(50), currency = Currency.getInstance("EUR"), valueOf(5)),
            label = "Le billet futé",
            conditions = "Valable toute l'année sauf noël et halloween",
            description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, sous conditions",
            isDated = true,
            validityStartDate = LocalDate.of(2021, 1, 1),
            validityEndDate = LocalDate.of(2021, 12, 31)
        )
    }

    fun getTicketLiberte(): Ticket {
        return Ticket(
            id = TicketId("LIBERTE"),
            price = Price(value = valueOf(60), currency = Currency.getInstance("EUR"), valueOf(6)),
            label = "Le billet liberté",
            conditions = "Valable toute l'année même noël et halloween",
            description = "Achetez votre billet maintenant pour venir quand vous le souhaitez, même les jours de fête",
            isDated = true,
            validityStartDate = LocalDate.of(2022, 1, 1),
            validityEndDate = LocalDate.of(2022, 12, 31)
        )
    }
}