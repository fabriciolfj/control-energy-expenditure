package com.github.fabriciolfj.controlenergyexpenditure.entities

import java.math.BigDecimal
import java.time.LocalDateTime

data class ConsumeEntity(val code: String,
                         val name: String,
                         val description: String,
                         val dateTime: LocalDateTime,
                         val value: BigDecimal,
                         val tag: String)