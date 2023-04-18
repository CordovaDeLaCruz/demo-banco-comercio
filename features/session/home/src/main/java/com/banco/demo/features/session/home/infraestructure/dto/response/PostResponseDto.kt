package com.banco.demo.features.session.home.infraestructure.dto.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostResponseDto(

    @SerializedName("body")
    @Expose
    val body: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("userId")
    @Expose
    val userId: Int

)