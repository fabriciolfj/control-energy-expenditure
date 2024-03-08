package com.github.fabriciolfj.controlenergyexpenditure.fixture

import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ConsumeRequest
import java.math.BigDecimal

class ConsumeRequestFixture {

    companion object {
        fun toValid() =
                ConsumeRequest(
                        "teste",
                        "conta energia",
                        BigDecimal.TEN,
                        "casa"
                )
    }
}