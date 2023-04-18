/* Banco Demo 2023 */
package com.banco.demo.features.splash.di

import com.banco.demo.commons.features.domain.repository.ParameterRepository
import com.banco.demo.commons.features.domain.usecase.parameter.GetParametersByGroupUseCase
import com.banco.demo.features.splash.domain.usecase.SplashUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SplashModule {





    @Provides
    @Singleton
    fun provideSplashUseCases(
        repository: ParameterRepository,
    ): SplashUseCases {
        return SplashUseCases(
            getParametersByGroup = GetParametersByGroupUseCase(repository)
        )
    }
}
