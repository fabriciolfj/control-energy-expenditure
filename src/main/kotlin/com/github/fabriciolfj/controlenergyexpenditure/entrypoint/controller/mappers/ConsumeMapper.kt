package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.mappers

import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ConsumeRequest
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ConsumeResponse
import java.time.LocalDateTime
import java.util.UUID

class ConsumeMapper {

    companion object {
        fun toEntity(consume: ConsumeRequest) =
                ConsumeEntity(UUID.randomUUID().toString(),
                        consume.name,
                        consume.description,
                        LocalDateTime.now(),
                        consume.value,
                        consume.tag)

        fun toResponse(entity: ConsumeEntity) =
                ConsumeResponse(entity.name,
                        entity.description,
                        entity.dateTime,
                        entity.value,
                        entity.tag)

    }
}