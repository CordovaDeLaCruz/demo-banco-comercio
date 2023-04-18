package com.banco.demo.commons.domain.entity

data class Option(
    val code: String,
    val name: String,
) {

    override fun toString(): String {
        return this.name
    }
}