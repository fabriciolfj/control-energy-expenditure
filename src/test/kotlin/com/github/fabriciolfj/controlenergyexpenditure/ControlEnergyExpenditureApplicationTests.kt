package com.github.fabriciolfj.controlenergyexpenditure

import com.github.fabriciolfj.controlenergyexpenditure.exceptionshandler.advice.RestControllerAdvice
import org.apache.commons.lang3.StringUtils
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.MessageSource
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors


@ExtendWith(MockitoExtension::class, SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [ControlEnergyExpenditureApplication::class])
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ControlEnergyExpenditureApplicationTests {

	protected lateinit var mvc: MockMvc

	@Autowired
	private lateinit var messageSource: MessageSource

	protected fun setUp(controller: Any) {
		mvc = MockMvcBuilders.standaloneSetup(controller)
				.setControllerAdvice(RestControllerAdvice(messageSource))
				.build()
	}

	protected fun readRequestFileMapping(fileName: String) : String {
		return readFileMapping(fileName, "requests")
	}

	protected fun readResponseFileMapping(fileName: String) : String {
		return readFileMapping(fileName, "responses")
	}

	private fun readFileMapping(fileName: String, filePath: String) : String {
		val inputStream = this.javaClass.classLoader.getResourceAsStream("$filePath/$fileName")
		val fileString = convert(inputStream)
		val result = StringUtils.replace(fileString, "\n", "")

		return StringUtils.normalizeSpace(result)
	}

	private fun convert(inputStream: InputStream) : String {
		val reader = InputStreamReader(inputStream, StandardCharsets.UTF_8)
		return BufferedReader(reader).lines()
				.collect(Collectors.joining("\n"))
	}
}
