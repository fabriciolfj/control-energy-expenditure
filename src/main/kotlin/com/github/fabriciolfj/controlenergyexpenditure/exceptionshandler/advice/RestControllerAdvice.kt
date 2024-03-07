package com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.advice

import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.dto.MessageErrorDTO
import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.enums.ErrorsEnum
import jakarta.validation.ConstraintViolationException
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class RestControllerAdvice(private val messageSource: MessageSource) {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(ex: ConstraintViolationException) : ResponseEntity<*>? {
        val dto = MessageErrorDTO(ErrorsEnum.VALUE_NOT_INFORMED.getMessage(), HttpStatus.BAD_REQUEST.toString())
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, bindingResult: BindingResult): ResponseEntity<*>? {
        val result = bindingResult.fieldErrors.map {
            val message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            MessageErrorDTO.FieldInvalid(message, it.field)
        }.toList()

        return ResponseEntity.badRequest().body(MessageErrorDTO(ErrorsEnum.INVALID_REQUEST.getMessage(), HttpStatus.BAD_REQUEST.toString(), result))
    }

}