package com.banco.demo.commons.libs.social_network

import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import com.firebase.ui.auth.AuthUI

object AuthSocialNetworkUI {


    fun invoke(
        socialNetworkType: String = SocialNetworkType.Google.name,
        signInLauncher: ActivityResultLauncher<Intent>,
    ) {
        when (socialNetworkType) {
            SocialNetworkType.Google.name -> invokeGoogle(signInLauncher)
            SocialNetworkType.Facebook.name -> invokeFacebook(signInLauncher)
        }
    }

    private fun invokeGoogle(
        signInLauncher: ActivityResultLauncher<Intent>,
    ) {
        val providers = arrayListOf(AuthUI.IdpConfig.GoogleBuilder().build())
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    private fun invokeFacebook(
        signInLauncher: ActivityResultLauncher<Intent>,
    ) {

        val providers = arrayListOf(AuthUI.IdpConfig.FacebookBuilder().build())
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }
}