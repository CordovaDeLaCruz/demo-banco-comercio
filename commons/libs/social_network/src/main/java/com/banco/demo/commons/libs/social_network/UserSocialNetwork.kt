package com.banco.demo.commons.libs.social_network

import android.net.Uri

data class UserSocialNetwork(
    val uid: String,
    val email: String?,
    val displayName: String?,
    val phoneNumber: String?,
    val photoUrl: Uri?
)
