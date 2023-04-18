/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dynamickey

import com.banco.demo.commons.domain.entity.Response
import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey
import com.banco.demo.commons.features.domain.repository.DynamicKeyRepository
import com.banco.demo.commons.features.infrastructure.dynamickey.service.DynamicKeyService
import com.banco.demo.commons.libs.networking.mapper.ResponseMapper
import javax.inject.Inject

class DynamicKeyRepositoryImpl @Inject constructor(
    private val apiService: DynamicKeyService,
    private val responseGenerateDynamicKeyMapper: ResponseMapper<GenerateDynamicKey>,
    private val responseValidateDynamicKeyMapper: ResponseMapper<ValidateDynamicKey>,
) : DynamicKeyRepository {

    override suspend fun generateDynamicKey(phoneNumber: String?): Response<GenerateDynamicKey> {
        var response: Response<GenerateDynamicKey>?
        apiService.generateDynamicKey(phoneNumber).also {
            response = responseGenerateDynamicKeyMapper.mapFromModel(
                type = it
            )
        }
        return response!!
    }

    override suspend fun validateDynamicKey(
        pin: String?,
        pinId: String?
    ): Response<ValidateDynamicKey> {
        var response: Response<ValidateDynamicKey>?
        apiService.validateDynamicKey(pin, pinId).also {
            response = responseValidateDynamicKeyMapper.mapFromModel(
                type = it
            )
        }
        return response!!
    }


}
