package com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MessageErrorDTO(
        val message: String?,
        val code: String,
        val fields: List<FieldInvalid>? = null) {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class FieldInvalid(val message: String?, val value: String? = null)
}