/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.dynamickey

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.repository.DynamicKeyRepository

class GenerateDynamicKeyUseCase constructor(private val repository: DynamicKeyRepository) {

    suspend operator fun invoke(
        phoneNumber: String?
    ): Response<GenerateDynamicKey> {

        return repository.generateDynamicKey(phoneNumber)
    }

    sealed class Invalid {
        object PhoneNumber : Invalid()
    }

}
