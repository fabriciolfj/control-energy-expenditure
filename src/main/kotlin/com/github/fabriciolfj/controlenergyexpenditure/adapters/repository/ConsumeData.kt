package com.github.fabriciolfj.controlenergyexpenditure.adapters.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Table(name = "gastos")
@Entity
data class ConsumeData(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @Column(name = "nome_pessoa", nullable = false)
        var name: String,
        @Column(name = "codigo", nullable = false)
        var code: String,
        @Column(name = "descricao", nullable = false)
        var description: String,
        @Column(name = "data_hora", nullable = false)
        var dateTime: LocalDateTime,
        @Column(name = "valor", nullable = false)
        var value: BigDecimal,
        var tag: String)


