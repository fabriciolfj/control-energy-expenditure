package com.github.fabriciolfj.controlenergyexpenditure.adapters.providers

import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeData
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeDataMapper
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeRepository
import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.SaveConsumeProvider
import org.springframework.stereotype.Component

@Component
class SaveConsumeProviderImpl(private val repository: ConsumeRepository) : SaveConsumeProvider {

    override fun process(entity: ConsumeEntity) {
        val data = ConsumeDataMapper.toData(entity)

        repository.save(data)
    }
}