package com.github.fabriciolfj.controlenergyexpenditure.annotations

import com.github.fabriciolfj.controlenergyexpenditure.annotations.impl.ParameterInformedImpl
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [ParameterInformedImpl::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class ParameterInformed(

        val message: String = "value not informed",
        val alias: String,
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<Payload>> = []
)
