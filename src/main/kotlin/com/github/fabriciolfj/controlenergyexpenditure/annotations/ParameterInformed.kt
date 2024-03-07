package com.github.fabriciolfj.controlenergyexpenditure.annotations

import com.github.fabriciolfj.controlenergyexpenditure.annotations.impl.ParameterInformedImpl
import jakarta.validation.Constraint

@Constraint(validatedBy = [ParameterInformedImpl::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ParameterInformed(

        val message: String = "value not informed"
)
