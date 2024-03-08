package com.github.fabriciolfj.controlenergyexpenditure.adapters.providers

import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeDataMapper
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeRepository
import com.github.fabriciolfj.controlenergyexpenditure.entities.ReportConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindListConsumesProvider
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.domain.Sort.Direction
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class FindListConsumesProviderImpl(private val repository: ConsumeRepository) : FindListConsumesProvider {

    companion object {
        const val PAGES = 10
    }

    override fun process(page: Int, dateInit: LocalDateTime, dateEnd: LocalDateTime) : ReportConsumeEntity {
        val page = PageRequest.of(page, PAGES, Sort.by(Direction.DESC, "dateTime"))
        val result = repository.findByDateTimeBetween(dateInit, dateEnd, page)

        val entities = result.toList().map { ConsumeDataMapper.toEntity(it) }.toList()
        return ReportConsumeEntity(result.totalPages, entities)
    }
}