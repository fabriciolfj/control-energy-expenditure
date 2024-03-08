package com.github.fabriciolfj.controlenergyexpenditure.usecase.impl

import com.github.fabriciolfj.controlenergyexpenditure.annotations.UseCase
import com.github.fabriciolfj.controlenergyexpenditure.entities.AverageDayEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindListConsumesProvider
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ReportAverageConsumeUseCase
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@UseCase
class ReportAverageConsumeUseCaseImpl(private val findListConsumesProvider: FindListConsumesProvider) : ReportAverageConsumeUseCase {

    companion object {
        val logger = LoggerFactory.getLogger(ReportAverageConsumeUseCase::class.java)
    }

    @Transactional(propagation = Propagation.NEVER, readOnly = true, isolation = Isolation.READ_COMMITTED)
    override fun execute(dateInit: LocalDate, dateEnd: LocalDate, page: Int): List<AverageDayEntity> {
        val report = findListConsumesProvider.process(page, dateInit.atStartOfDay(), LocalDateTime.of(dateEnd, LocalTime.MAX))

        logger.info("M execute, params $dateInit - $dateEnd - $page, total consumes ${report.consumes.size}")
        return report.consumes.groupBy { it.dateTime.toLocalDate() }
                .map { (date, consumes) ->
                    val average = consumes.sumOf { it.value } / BigDecimal(consumes.size)
                    AverageDayEntity(date, average)
                }

    }
}