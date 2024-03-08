package com.github.fabriciolfj.controlenergyexpenditure.fixture

import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeData
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

class ConsumeDataFixture {

    companion object {

        fun toValid() =
                ConsumeData(1L, "test", UUID.randomUUID().toString(),
                        "conta energia", LocalDateTime.parse("2024-05-08T00:00:00"), BigDecimal.TEN, "casa")

        fun toValids() =
                PageImpl(arrayListOf(ConsumeData(1L, "test", UUID.randomUUID().toString(),
                        "conta energia", LocalDateTime.parse("2024-05-06T00:00:00"), BigDecimal.TEN, "casa"),
                        ConsumeData(2L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-06T00:00:00"), BigDecimal.valueOf(19), "casa"),
                        ConsumeData(3L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-06T00:00:00"), BigDecimal.TEN, "casa"),
                        ConsumeData(4L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-08T00:00:00"), BigDecimal.TEN, "casa"),
                        ConsumeData(5L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-08T00:00:00"), BigDecimal.TEN, "casa"),
                        ConsumeData(61L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-08T00:00:00"), BigDecimal.TEN, "casa"),
                        ConsumeData(7L, "test", UUID.randomUUID().toString(),
                                "conta energia", LocalDateTime.parse("2024-05-08T00:00:00"), BigDecimal.TEN, "casa")),
                        )
    }
}