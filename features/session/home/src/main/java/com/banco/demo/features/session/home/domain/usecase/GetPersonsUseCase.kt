package com.banco.demo.features.session.home.domain.usecase

import com.banco.demo.features.session.home.domain.entity.PersonDate
import com.banco.demo.features.session.home.domain.repository.HomeRepository

class GetPersonsUseCase constructor(private val repository: HomeRepository) {


    suspend operator fun invoke(
    ): List<PersonDate> {
        return repository.getPersons()
    }

    class InvalidGetPersonsException(message: String) : Exception(message)
}