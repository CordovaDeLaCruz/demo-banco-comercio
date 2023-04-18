package com.banco.demo.commons.libs.social_network

sealed class SocialNetworkType(val name: String){
    object Facebook: SocialNetworkType("Facebook")
    object Google: SocialNetworkType("Google")
}