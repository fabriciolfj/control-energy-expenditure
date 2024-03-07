package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity

interface FindConsumeUseCase {

    fun execute(code: String) : ConsumeEntity
}