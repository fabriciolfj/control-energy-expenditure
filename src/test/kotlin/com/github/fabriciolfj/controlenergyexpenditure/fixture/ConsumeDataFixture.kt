package com.github.fabriciolfj.controlenergyexpenditure.fixture

import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeData
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

class ConsumeDataFixture {

    companion object {

        fun toValid() =
                ConsumeData(1L, "test", UUID.randomUUID().toString(),
                        "conta energia", LocalDateTime.now(), BigDecimal.TEN, "casa")
    }
}