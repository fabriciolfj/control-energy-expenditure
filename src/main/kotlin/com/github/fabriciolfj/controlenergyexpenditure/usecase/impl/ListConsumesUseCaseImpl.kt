package com.github.fabriciolfj.controlenergyexpenditure.usecase.impl

import com.github.fabriciolfj.controlenergyexpenditure.annotations.UseCase
import com.github.fabriciolfj.controlenergyexpenditure.entities.ReportConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindListConsumesProvider
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ListConsumesUseCase
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@UseCase
class ListConsumesUseCaseImpl(private val findListConsumesProvider: FindListConsumesProvider) : ListConsumesUseCase {

    companion object {
        val logger = LoggerFactory.getLogger(ListConsumesUseCaseImpl::class.java)
    }

    override fun execute(dateInit: LocalDate, dateEnd: LocalDate, page: Int) : ReportConsumeEntity {
        val report = findListConsumesProvider.process(page, dateInit.atStartOfDay(), LocalDateTime.of(dateEnd, LocalTime.MAX))

        logger.info("M execute, params $dateInit - $dateEnd - $page, total consumes ${report.consumes.size}")
        return report
    }
}