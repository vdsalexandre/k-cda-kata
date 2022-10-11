package test

import assertk.assertThat
import assertk.assertions.isEqualTo
import factory.DataTicketFactory.getTicketFute
import factory.DataTicketFactory.getTicketGaulois
import factory.DataTicketFactory.getTicketLiberte
import factory.DataTicketFactory.getTicketList
import mock.MockMetadataRepository
import mock.MockTicketingRepository
import org.junit.jupiter.api.Test
import ticket.TicketAggregator
import java.time.LocalDate

class TicketAggregatorTest {

    private val metaDataTicketRepository = MockMetadataRepository()
    private val ticketingTicketRepository = MockTicketingRepository()
    private val ticketAggregator = TicketAggregator(metaDataTicketRepository, ticketingTicketRepository)

    @Test
    fun `should retrieve the list of all tickets using both repositories`() {
        val expectedTickets = getTicketList()

        val tickets = ticketAggregator.listTickets()

        assertThat(tickets).isEqualTo(expectedTickets)
    }

    @Test
    fun `should retrieve the ticket using the id`() {
        val expectedTickets = getTicketGaulois()

        val tickets = ticketAggregator.getTicket(expectedTickets.id)

        assertThat(tickets).isEqualTo(expectedTickets)
    }

    @Test
    fun `should retrieve the dated tickets`() {
        val expectedTickets = listOf(getTicketGaulois(), getTicketLiberte())

        val tickets = ticketAggregator.listDatedTickets()

        assertThat(tickets).isEqualTo(expectedTickets)
    }

    @Test
    fun `should retrieve the undated tickets`() {
        val expectedTickets = listOf(getTicketFute())

        val tickets = ticketAggregator.listUndatedTickets()

        assertThat(tickets).isEqualTo(expectedTickets)
    }

    @Test
    fun `should retrieve the dated tickets using a defined date`() {
        val expectedTickets = listOf(getTicketGaulois(), getTicketLiberte())
        val expectedDate = LocalDate.of(2022, 1, 2)

        val tickets = ticketAggregator.listValidTickets(expectedDate)

        assertThat(tickets).isEqualTo(expectedTickets)
    }
}