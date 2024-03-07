package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class ConsumeResponse(val name: String,
                           val description: String,
                           val dateTime: LocalDateTime,
                           val value: BigDecimal,
                           val tag: String)