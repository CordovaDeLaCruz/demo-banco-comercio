/* Banco Demo 2023 */
package com.banco.demo.commons.features.domain.repository

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey


interface DynamicKeyRepository {

    suspend fun generateDynamicKey(
        phoneNumber: String?
    ): Response<GenerateDynamicKey>

    suspend fun validateDynamicKey(
        pin: String?,
        pinId: String?,
    ): Response<ValidateDynamicKey>

}
