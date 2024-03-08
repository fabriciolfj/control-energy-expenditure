package com.github.fabriciolfj.controlenergyexpenditure.entrypoint.controller

import com.github.fabriciolfj.controlenergyexpenditure.ControlEnergyExpenditureApplicationTests
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeData
import com.github.fabriciolfj.controlenergyexpenditure.adapters.repository.ConsumeRepository
import com.github.fabriciolfj.controlenergyexpenditure.fixture.ConsumeDataFixture
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.MockBeans
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ConsumeControllerTest : ControlEnergyExpenditureApplicationTests() {

    @Autowired
    private lateinit var controller: ConsumeController

    @MockBean
    private lateinit var repository: ConsumeRepository

    @BeforeEach
    fun testInit() {
        setUp(controller)
    }

    @Test
    @DisplayName("create success consume")
    fun testCreateSuccessConsume() {
        val data = ConsumeDataFixture.toValid()
        whenever(repository.save(data)).thenReturn(data)

        val result = mvc.perform(post("/consume/api/v1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(readRequestFileMapping("request_valid.json")))

        result
                .andExpect(jsonPath("\$.code").exists())
                .andExpect(status().is2xxSuccessful)

    }
}