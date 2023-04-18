package com.banco.demo.commons.domain.entity

data class Parameter(

    val description: String,
    val value: String,
    val group: String,
) {

    companion object {
        const val GROUP_DOCUMENT_DNI_DESCRIPTION = "1"
        const val GROUP_DOCUMENT_PASSPORT_DESCRIPTION = "2"
        const val GROUP_DOCUMENT_IMMIGRATION_DESCRIPTION = "3"
    }

    override fun toString(): String {
        return value
    }
}
