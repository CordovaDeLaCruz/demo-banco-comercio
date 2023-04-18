package com.banco.demo.commons.libs.social_network

interface SocialNetworkState {
    fun toSuccess(userInfo: UserSocialNetwork, socialNetworkType: String)
    fun toError(message: String?, socialNetworkType: String)
}
