package com.github.fabriciolfj.controlenergyexpenditure.adapters.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.util.Optional

interface ConsumeRepository : JpaRepository<ConsumeData, Long> {

    fun findByCode(code: String) : Optional<ConsumeData>

    fun findByDateTimeBetween(dateIni: LocalDateTime, dateEnd: LocalDateTime, pageable: Pageable) : Page<ConsumeData>
}