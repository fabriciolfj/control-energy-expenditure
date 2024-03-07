package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity

interface SaveConsumeProvider {

    fun process(entity: ConsumeEntity)
}