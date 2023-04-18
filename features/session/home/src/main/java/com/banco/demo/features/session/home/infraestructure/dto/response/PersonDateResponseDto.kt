package com.banco.demo.features.session.home.infraestructure.dto.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PersonDateResponseDto(
    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("website")
    @Expose
    val website: String
)