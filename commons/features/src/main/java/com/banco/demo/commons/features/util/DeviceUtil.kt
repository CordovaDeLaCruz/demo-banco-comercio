package com.banco.demo.commons.features.util

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.text.TextUtils

object DeviceUtil {
    fun getAndroidId(context: Context): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    val versionAndroid: String
        get() = Build.VERSION.RELEASE
    val brandAndModel: String
        get() {
            val brand = brand
            val model = model
            var name = brand
            if (!TextUtils.isEmpty(model)) {
                name += " $model"
            }
            return name
        }
    val brand: String
        get() {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                com.banco.demo.commons.features.util.CommonUtil.capitalize(model)
            } else com.banco.demo.commons.features.util.CommonUtil.capitalize(manufacturer)
        }
    val model: String
        get() {
            val manufacturer = Build.MANUFACTURER
            val model = Build.MODEL
            return if (model.startsWith(manufacturer)) {
                ""
            } else com.banco.demo.commons.features.util.CommonUtil.capitalize(model)
        }
}
