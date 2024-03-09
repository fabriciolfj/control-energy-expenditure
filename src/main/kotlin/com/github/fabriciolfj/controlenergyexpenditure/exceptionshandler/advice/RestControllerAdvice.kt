package com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.advice

import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.dto.MessageErrorDTO
import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.enums.ErrorsEnum
import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.exceptions.ConsumeNotFoundException
import jakarta.servlet.http.HttpServletRequest
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
    fun handleConstraintViolationException(ex: ConstraintViolationException, request: HttpServletRequest?): ResponseEntity<*>? {
        val camposInvalidos = ex.constraintViolations.map {
            MessageErrorDTO.FieldInvalid(field = it.propertyPath.toString(), message = ErrorsEnum.INVALID_REQUEST.getMessage(),
                    value = if (it.invalidValue == null || it.invalidValue?.toString()?.isEmpty() == true) null
                    else it.invalidValue?.toString())
        }.toList()

        val details = MessageErrorDTO(null, HttpStatus.BAD_REQUEST.toString(), camposInvalidos)
        return ResponseEntity.badRequest().body(details)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, bindingResult: BindingResult): ResponseEntity<*>? {
        val result = bindingResult.fieldErrors.map {
            val message = messageSource.getMessage(it, LocaleContextHolder.getLocale())
            MessageErrorDTO.FieldInvalid(message, it.field)
        }.toList()

        return ResponseEntity.badRequest().body(MessageErrorDTO(ErrorsEnum.INVALID_REQUEST.getMessage(), HttpStatus.BAD_REQUEST.toString(), result))
    }

    @ExceptionHandler(ConsumeNotFoundException::class)
    fun handleConsumeNotFoundException(ex: ConsumeNotFoundException) : ResponseEntity<*>? {
        val dto = MessageErrorDTO(ex.message, HttpStatus.BAD_REQUEST.toString())
        return ResponseEntity.badRequest().body(dto)
    }

}