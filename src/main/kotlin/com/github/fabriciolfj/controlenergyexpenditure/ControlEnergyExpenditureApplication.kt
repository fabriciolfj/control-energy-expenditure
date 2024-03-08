package com.github.fabriciolfj.controlenergyexpenditure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.github.fabriciolfj.controlenergyexpenditure"])
class ControlEnergyExpenditureApplication

fun main(args: Array<String>) {
	runApplication<ControlEnergyExpenditureApplication>(*args)
}
