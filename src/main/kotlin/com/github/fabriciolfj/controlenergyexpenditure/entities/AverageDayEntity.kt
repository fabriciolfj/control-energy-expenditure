package com.github.fabriciolfj.controlenergyexpenditure.entities

import java.math.BigDecimal
import java.time.LocalDate

data class AverageDayEntity(val date: LocalDate, val value: BigDecimal)