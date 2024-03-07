package com.github.fabriciolfj.controlenergyexpenditure.adapters.providers

import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeDataMapper.Companion.toEntity
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeRepository
import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.exceptions.ConsumeNotFoundException
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindConsumeProvider
import org.springframework.stereotype.Component

@Component
class FindConsumeProviderImpl(private val repository: ConsumeRepository) : FindConsumeProvider {

    override fun process(code: String): ConsumeEntity {
        return repository.findByCode(code)
                .map { toEntity(it) }
                .orElseThrow { ConsumeNotFoundException() }
    }
}