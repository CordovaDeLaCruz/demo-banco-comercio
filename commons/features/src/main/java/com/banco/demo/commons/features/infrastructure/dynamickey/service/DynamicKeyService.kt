/* Banco Demo 2023 */
package com.banco.demo.commons.features.infrastructure.dynamickey.service

import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey
import com.banco.demo.commons.features.infrastructure.dto.request.GenerateDynamicKeyRequestDto
import com.banco.demo.commons.features.infrastructure.dto.request.ValidateDynamicKeyRequestDto
import com.banco.demo.commons.libs.networking.dto.ResponseDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DynamicKeyService @Inject constructor(private val retrofit: Retrofit) {

    suspend fun generateDynamicKey(phoneNumber: String?): ResponseDto<GenerateDynamicKey>{
        return withContext(Dispatchers.IO) {
            val generateDynamicKeyRequest =
                GenerateDynamicKeyRequestDto(phoneNumber)
            val response = retrofit.create(DynamicKeyApiClient::class.java)
                .generateDynamicKey(generateDynamicKeyRequest)
            response.body()!!
        }
    }

    suspend fun validateDynamicKey(pin: String?, pinId: String?): ResponseDto<ValidateDynamicKey>{
        return withContext(Dispatchers.IO) {
            val validateDynamicKeyRequest =
                ValidateDynamicKeyRequestDto(pin, pinId)
            val response = retrofit.create(DynamicKeyApiClient::class.java)
                .validateDynamicKey(validateDynamicKeyRequest)
            response.body()!!
        }
    }

}
