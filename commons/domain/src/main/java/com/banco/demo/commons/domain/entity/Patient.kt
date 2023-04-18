package com.banco.demo.commons.domain.entity

data class Patient(
    val documentType: String,
    val documentNumber: String,
    val name: String,
    val gender: String,
    val idPatient: String,
    val phoneNumber: String,
    val token: String,
)
