package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity

interface ConsumeCreateUseCase {

    fun execute(entity: ConsumeEntity) : ConsumeEntity
}