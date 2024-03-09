package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller

import com.github.fabriciolfj.controlenergyexpenditure.annotations.ParameterInformed
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ConsumeRequest
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ConsumeResponse
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto.ReportAverageResponse
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.mappers.ConsumeMapper.Companion.toEntity
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.mappers.ConsumeMapper.Companion.toReportAverageResponse
import com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.mappers.ConsumeMapper.Companion.toResponse
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ConsumeCreateUseCase
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindConsumeUseCase
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ListConsumesUseCase
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ReportAverageConsumeUseCase
import jakarta.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@Validated
@RestController
@RequestMapping("/v1/api/consume")
class ConsumeController(private val createUseCase: ConsumeCreateUseCase,
                        private val findConsumeUseCase: FindConsumeUseCase,
                        private val reportAverageConsumeUseCase: ReportAverageConsumeUseCase,
                        private val listConsumesUseCase: ListConsumesUseCase) {

    companion object {
        val logger = LoggerFactory.getLogger(ConsumeController::class.java)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createConsume(@Valid @RequestBody consumeRequest: ConsumeRequest) : ConsumeResponse {
        logger.info("M createConsume, payload $consumeRequest")
        val entity = createUseCase.execute(toEntity(consumeRequest))

        return toResponse(entity)
    }

    @GetMapping("/report")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findReport(@ParameterInformed(alias = "dateInit") @RequestParam(required = false) dateInit: String,
                   @ParameterInformed(alias = "dateEnd") @RequestParam(required = false) dateEnd: String,
                   @RequestParam(required = false, defaultValue = "0", value = "page") page: Int) : List<ReportAverageResponse> {

        logger.info("M findReport, params $dateInit - $dateEnd - $page")
        val result = reportAverageConsumeUseCase.execute(LocalDate.parse(dateInit), LocalDate.parse(dateEnd), page)

        return toReportAverageResponse(result)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findAll(@ParameterInformed(alias = "dateInit") @RequestParam(required = false) dateInit: String,
                @ParameterInformed(alias = "dateEnd") @RequestParam(required = false) dateEnd: String,
                @RequestParam(required = false, defaultValue = "0", value = "page") page: Int) : List<ConsumeResponse> {

        logger.info("M findReport, params $dateInit - $dateEnd - $page")
        val result = listConsumesUseCase.execute(LocalDate.parse(dateInit), LocalDate.parse(dateEnd), page)

        return toResponse(result)
    }

    @GetMapping("/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun findConsume(@ParameterInformed(alias = "code") @PathVariable("code") code: String) : ConsumeResponse {
        logger.info("M findConsume, payload: $code")
        val entity = findConsumeUseCase.execute(code)

        return toResponse(entity)
    }
}