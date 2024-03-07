package com.github.fabriciolfj.controlenergyexpenditure.annotations

import org.springframework.stereotype.Service

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Service
annotation class UseCase()
