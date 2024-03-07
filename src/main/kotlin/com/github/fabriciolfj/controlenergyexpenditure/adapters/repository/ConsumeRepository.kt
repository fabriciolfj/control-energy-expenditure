package com.github.fabriciolfj.controlenergyexpenditure.adapters.repository

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ConsumeRepository : JpaRepository<ConsumeData, Long> {

    fun findByCode(code: String) : Optional<ConsumeData>
}