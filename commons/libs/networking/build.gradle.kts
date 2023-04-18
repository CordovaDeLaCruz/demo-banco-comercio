import  com.banco.demo.configuration.constants.AndroidBuildConfig
import  com.banco.demo.configuration.constants.Dependencies
import  com.banco.demo.configuration.constants.Modules

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AndroidBuildConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidBuildConfig.MIN_SDK
        targetSdk = AndroidBuildConfig.TARGET_SDK
        testInstrumentationRunner = AndroidBuildConfig.INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AndroidBuildConfig.JVM_TARGET
    }
}

dependencies {

    implementation(project(Modules.DOMAIN))

    implementation(Dependencies.COREKTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)

    //RETROFIT
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGER)

    //HILT
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    implementation(Dependencies.HILT_VIEW_MODEL)
    kapt(Dependencies.HILT_COMPILER)

    //Crashlytics
    implementation(platform(Dependencies.FIREBASE_BOM))
    implementation(Dependencies.FIREBASE_CRASHLYTICS)
    implementation(Dependencies.FIREBASE_PERFORMANCE)

    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.JUNIT_EXT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
}