package com.banco.demo.configuration.constants

object Dependencies {
    private const val KOTLIN_VERSION = "1.1.1"
    const val COMPOSE_VERSION = "1.1.1"

    const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$KOTLIN_VERSION"


    const val COREKTX = "androidx.core:core-ktx:1.7.0"
    const val APPCOMPAT = "androidx.appcompat:appcompat:1.4.1"
    const val MATERIAL = "com.google.android.material:material:1.6.0"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:1.4.0"


    //COMPOSE
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:2.4.1"
    const val COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED =
        "androidx.compose.material:material-icons-extended:$COMPOSE_VERSION"
    const val COMPOSE_HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
    const val COMPOSE_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:1.0.0"


    //Coroutines
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"

    //Dagger - Hilt
    const val HILT = "com.google.dagger:hilt-android:2.40"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:2.40"
    const val HILT_VIEW_MODEL = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:4.9.3"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.3"

    //Room
    const val ROOM = "androidx.room:room-ktx:2.4.2"
    const val ROOM_COMPILER = "androidx.room:room-compiler:2.4.2"

    //Firebase
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:30.1.0"
    const val FIREBASE_UI_AUTH = "com.firebaseui:firebase-ui-auth:8.0.1"
    const val PLAY_SERVICES_AUTH = "com.google.android.gms:play-services-auth:20.2.0"
    const val FIREBASE_AUTH = "com.google.firebase:firebase-auth:21.0.6"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    const val FIREBASE_PERFORMANCE = "com.google.firebase:firebase-perf-ktx"

    //Facebook
    const val FACEBOOK_ANDROID_SDK = "com.facebook.android:facebook-android-sdk:[8,9)"

    //Calendar View
    const val CALENDAR_THREETENBP = "org.threeten:threetenbp:1.5.1"

    //CIL IMAGE
    const val COIL = "io.coil-kt:coil:2.1.0"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:2.1.0"
    const val COIL_GIF = "io.coil-kt:coil-gif:2.1.0"


    const val IMAGE_CROPPER = "com.github.CanHub:Android-Image-Cropper:4.3.0"

    //TEST
    const val JUNIT = "junit:junit:4.+"
    const val JUNIT_EXT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
    const val COMPOSE_UI_TEST = "androidx.compose.ui:ui-test-junit4:$COMPOSE_VERSION"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
}