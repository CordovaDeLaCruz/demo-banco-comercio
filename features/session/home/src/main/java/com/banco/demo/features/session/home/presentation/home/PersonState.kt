package com.banco.demo.features.session.home.presentation.home

import com.banco.demo.features.session.home.domain.entity.PersonDate

data class PersonState(
    val persons: List<PersonDate> = emptyList()
)
