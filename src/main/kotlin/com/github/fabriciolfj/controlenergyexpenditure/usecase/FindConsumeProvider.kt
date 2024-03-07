package com.github.fabriciolfj.controlenergyexpenditure.usecase

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity

interface FindConsumeProvider {

    fun process(code: String) : ConsumeEntity
}