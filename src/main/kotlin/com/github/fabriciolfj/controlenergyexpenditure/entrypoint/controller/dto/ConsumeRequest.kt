package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class ConsumeRequest(@get:NotBlank(message = "name not informed")
                          val name: String,
                          @get:NotBlank(message = "description not informed")
                          val description: String,
                          @get:NotBlank(message = "value not informed")
                          @get:Positive(message = "is no more than zero")
                          val value: BigDecimal,
                          @get:NotBlank(message = "tag not informed")
                          val tag: String)