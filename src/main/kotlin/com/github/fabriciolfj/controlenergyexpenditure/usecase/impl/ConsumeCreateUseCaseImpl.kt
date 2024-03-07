package com.github.fabriciolfj.controlenergyexpenditure.usecase.impl

import com.github.fabriciolfj.controlenergyexpenditure.annotations.UseCase
import com.github.fabriciolfj.controlenergyexpenditure.entities.ConsumeEntity
import com.github.fabriciolfj.controlenergyexpenditure.usecase.ConsumeCreateUseCase
import com.github.fabriciolfj.controlenergyexpenditure.usecase.SaveConsumeProvider
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@UseCase
class ConsumeCreateUseCaseImpl(private val provider : SaveConsumeProvider) : ConsumeCreateUseCase {

    companion object {
        private val logger = LoggerFactory.getLogger(ConsumeCreateUseCase::class.java)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    override fun execute(entity: ConsumeEntity): ConsumeEntity {
        provider.process(entity)

        logger.info("M execute, payload $entity, msg save success")
        return entity
    }
}