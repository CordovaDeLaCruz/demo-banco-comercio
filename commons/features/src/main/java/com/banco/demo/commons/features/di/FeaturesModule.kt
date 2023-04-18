package com.banco.demo.commons.features.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.banco.demo.commons.domain.entity.Parameter
import com.banco.demo.commons.domain.entity.User
import com.banco.demo.commons.features.domain.entity.CheckReniecDataClient
import com.banco.demo.commons.features.domain.entity.ClientValidateDocument
import com.banco.demo.commons.features.domain.entity.GenerateDynamicKey
import com.banco.demo.commons.features.domain.entity.ValidateDynamicKey
import com.banco.demo.commons.features.domain.repository.DynamicKeyRepository
import com.banco.demo.commons.features.domain.repository.ParameterRepository
import com.banco.demo.commons.features.domain.repository.UserRepository
import com.banco.demo.commons.features.infrastructure.dto.mapper.ParameterMapper
import com.banco.demo.commons.features.infrastructure.dynamickey.DynamicKeyRepositoryImpl
import com.banco.demo.commons.features.infrastructure.dynamickey.service.DynamicKeyService
import com.banco.demo.commons.features.infrastructure.local.FeaturesDatabase
import com.banco.demo.commons.features.infrastructure.parameter.ParameterRepositoryImpl
import com.banco.demo.commons.features.infrastructure.parameter.local.ParameterDao
import com.banco.demo.commons.features.infrastructure.parameter.local.ParameterLocal
import com.banco.demo.commons.features.infrastructure.parameter.service.ParameterService
import com.banco.demo.commons.features.infrastructure.user.service.UserRepositoryImpl
import com.banco.demo.commons.features.infrastructure.user.service.UserService
import com.banco.demo.commons.libs.networking.mapper.ResponseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object FeaturesModule {

    @Provides
    @Singleton
    fun provideFeaturesDatabase(app: Application): FeaturesDatabase {
        return Room.databaseBuilder(
            app,
            FeaturesDatabase::class.java,
            FeaturesDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideParameterDao(db: FeaturesDatabase): ParameterDao {
        return db.parameterDao
    }

    @Provides
    @Singleton
    fun provideParameterRepository(
        apiService: ParameterService,
        daoLocal: ParameterLocal,
        responseGetParametersMapper: ResponseMapper<List<Parameter>>,
        parameterMapper: ParameterMapper,
    ): ParameterRepository {
        return ParameterRepositoryImpl(
            apiService,
            daoLocal,
            responseGetParametersMapper,
            parameterMapper
        )
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        @ApplicationContext appContext: Context,
        apiService: UserService,
        responseAuthenticateUser: ResponseMapper<User>,
        responseValidateDocumentMapper: ResponseMapper<ClientValidateDocument>,
        responseCheckReniecMapper: ResponseMapper<CheckReniecDataClient>,

    ): UserRepository {
        return UserRepositoryImpl(
            appContext,
            apiService,
            responseAuthenticateUser,
            responseValidateDocumentMapper,
            responseCheckReniecMapper
        )
    }

    @Provides
    @Singleton
    fun provideDynamicKeyRepository(
        apiService: DynamicKeyService,
        responseGenerateDynamicKey: ResponseMapper<GenerateDynamicKey>,
        responseValidateDynamicKey: ResponseMapper<ValidateDynamicKey>

    ): DynamicKeyRepository{
        return DynamicKeyRepositoryImpl(
            apiService,
            responseGenerateDynamicKey,
            responseValidateDynamicKey
        )
    }

}
