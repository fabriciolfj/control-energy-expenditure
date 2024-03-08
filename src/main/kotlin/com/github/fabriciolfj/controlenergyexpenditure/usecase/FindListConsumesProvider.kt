package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ReportConsumeEntity
import java.time.LocalDateTime

interface FindListConsumesProvider {

    fun process(page: Int, dateInit: LocalDateTime, dateEnd: LocalDateTime): ReportConsumeEntity
}