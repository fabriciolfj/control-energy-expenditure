package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ReportConsumeEntity
import java.time.LocalDate

interface ListConsumesUseCase {

    fun execute(dateInit: LocalDate, dateEnd: LocalDate, page: Int) : ReportConsumeEntity
}