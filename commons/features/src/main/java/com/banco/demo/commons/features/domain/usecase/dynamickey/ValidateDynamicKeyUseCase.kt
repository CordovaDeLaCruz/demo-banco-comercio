/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.usecase.dynamickey

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey
import com.banco.demo.commons.features.domain.repository.DynamicKeyRepository

class ValidateDynamicKeyUseCase constructor(private val repository: DynamicKeyRepository) {

    suspend operator fun invoke(
        pin: String?,
        pinId: String?
    ): Response<ValidateDynamicKey> {

        return repository.validateDynamicKey(pin, pinId)
    }

    sealed class Invalid {
        object Pin : Invalid()
        object PinId : Invalid()
    }


}
