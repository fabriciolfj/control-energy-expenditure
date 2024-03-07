package com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.advice

import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.ControllerAdvice

@ControllerAdvice
class RestControllerAdvice(private val messageSource: MessageSource) {
}