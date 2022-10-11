package ticket.model

import java.math.BigDecimal
import java.util.Currency

data class Price(val value: BigDecimal, val currency: Currency, val taxValue: BigDecimal)
