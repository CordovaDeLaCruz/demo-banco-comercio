package com.banco.demo.commons.domain.validator

data class ChangeDocumentType(
    var minChar: Int = -1,
    var maxChar: Int = -1,
    var isInputTypeNumber: Boolean = false,
)