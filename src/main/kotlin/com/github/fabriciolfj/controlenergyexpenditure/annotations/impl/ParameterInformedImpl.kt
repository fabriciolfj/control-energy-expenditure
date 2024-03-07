package com.github.fabriciolfj.controlenergyexpenditure.annotations.impl

import com.github.fabriciolfj.controlenergyexpenditure.annotations.ParameterInformed
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ParameterInformedImpl : ConstraintValidator<ParameterInformed, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return !value.isNullOrEmpty()
    }
}