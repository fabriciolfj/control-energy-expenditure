package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto

import java.math.BigDecimal
import java.time.LocalDate

data class ReportAverageResponse(val date: LocalDate, val value: BigDecimal)