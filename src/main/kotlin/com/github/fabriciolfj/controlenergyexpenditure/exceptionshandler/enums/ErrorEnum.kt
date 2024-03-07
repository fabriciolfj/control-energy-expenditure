package com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.enums

import java.util.*

enum class ErrorsEnum {

    INVALID_REQUEST,
    CODE_CONSUME_NOT_FOUND,
    VALUE_NOT_INFORMED;

    fun getMessage() : String {
        val bundle = ResourceBundle.getBundle("exceptions/message")
        return bundle.getString("${this.name}.message")
    }
}