package com.github.fabriciolfj.controlenergyexpenditure.adapters.repository

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity

class ConsumeDataMapper {

    companion object {

        fun toData(entity: ConsumeEntity) =
                ConsumeData(null,
                        entity.name,
                        entity.code,
                        entity.description,
                        entity.dateTime,
                        entity.value,
                        entity.tag)

        fun toEntity(data: ConsumeData) =
                ConsumeEntity(
                        data.code,
                        data.name,
                        data.description,
                        data.dateTime,
                        data.value,
                        data.tag
                )
    }
}