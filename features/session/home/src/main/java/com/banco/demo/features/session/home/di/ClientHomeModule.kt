package com.banco.demo.features.session.home.di

import com.banco.demo.features.session.home.domain.repository.HomeRepository
import com.banco.demo.features.session.home.domain.usecase.ClientHomeUseCases
import com.banco.demo.features.session.home.domain.usecase.CreatePostUseCase
import com.banco.demo.features.session.home.domain.usecase.GetPersonsUseCase
import com.banco.demo.features.session.home.domain.usecase.GetPostsUseCase
import com.banco.demo.features.session.home.infraestructure.HomeRepositoryImp
import com.banco.demo.features.session.home.infraestructure.HomeService
import com.banco.demo.features.session.home.infraestructure.mapper.CreatePostMapper
import com.banco.demo.features.session.home.infraestructure.mapper.PersonMapper
import com.banco.demo.features.session.home.infraestructure.mapper.PostMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClientHomeModule {

    @Provides
    @Singleton
    fun provideProfileRepository(
        apiService: HomeService,
        responsePersonMapper: PersonMapper,
        responsePostMapper: PostMapper,
        responseCreatePostMapper: CreatePostMapper
    ): HomeRepository {
        return HomeRepositoryImp(
            apiService, responsePersonMapper, responsePostMapper, responseCreatePostMapper
        )
    }

    @Provides
    @Singleton
    fun provideHomeUseCases(
        homeRepository: HomeRepository
    ): ClientHomeUseCases {
        return ClientHomeUseCases(
            getPersonUseCase = GetPersonsUseCase(homeRepository),
            getPostsUseCase = GetPostsUseCase(homeRepository),
            createPostUseCase = CreatePostUseCase(homeRepository),
        )
    }
}