package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.AverageDayEntity
import java.time.LocalDate

interface ReportAverageConsumeUseCase {

    fun execute(dateInit: LocalDate, dateEnd: LocalDate, page: Int): List<AverageDayEntity>
}