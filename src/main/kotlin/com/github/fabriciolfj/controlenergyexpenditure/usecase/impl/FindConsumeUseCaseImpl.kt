package com.github.fabriciolfj.controlenergyexpenditure.usecase.impl

import com.github.fabriciolfj.controlenergyexpenditure.annotations.UseCase
import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindConsumeProvider
import com.github.fabriciolfj.controlenergyexpenditure.usecase.FindConsumeUseCase
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@UseCase
class FindConsumeUseCaseImpl(private val findConsumeProvider: FindConsumeProvider) : FindConsumeUseCase {

    companion object {
        private val logger = LoggerFactory.getLogger(FindConsumeUseCase::class.java)
    }

    @Transactional(propagation = Propagation.NEVER, readOnly = true, isolation = Isolation.READ_COMMITTED)
    override fun execute(code: String): ConsumeEntity {
        val entity = findConsumeProvider.process(code)

        logger.info("M execute, result: $entity")
        return entity
    }


}