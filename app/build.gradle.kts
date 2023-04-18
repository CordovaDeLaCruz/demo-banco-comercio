import  com.banco.demo.configuration.constants.AndroidBuildConfig
import  com.banco.demo.configuration.constants.Dependencies
import  com.banco.demo.configuration.constants.Modules

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

android {
    compileSdk = AndroidBuildConfig.COMPILE_SDK

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
    }

    defaultConfig {
        applicationId = AndroidBuildConfig.APPLICATION_ID
        minSdk = AndroidBuildConfig.MIN_SDK
        targetSdk = AndroidBuildConfig.TARGET_SDK
        versionCode = AndroidBuildConfig.VERSION_CODE
        versionName = AndroidBuildConfig.VERSION_NAME
        testInstrumentationRunner = AndroidBuildConfig.INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    flavorDimensions.addAll(listOf("mode"))
    productFlavors {
        create("mock") {
            applicationIdSuffix = ".mock"
            dimension = "mode"
            versionCode = 1
            versionName = "0.0.1"
            resValue("string", "app_name", "MOCK Banco Demo")
        }
        create("dev") {
            applicationIdSuffix = ".dev"
            dimension = "mode"
            versionCode = 1
            versionName = "0.0.1"
            resValue("string", "app_name", "DEV Banco Demo")
        }
        create("uat") {
            applicationIdSuffix = ".uat"
            dimension = "mode"
            versionCode = 1
            versionName = "0.0.1"
            resValue("string", "app_name", "UAT Banco Demo")
        }
        create("prod") {
            dimension = "mode"
            versionCode = 1
            versionName = "0.0.1"
            resValue("string", "app_name", "Banco Demo")
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = AndroidBuildConfig.JVM_TARGET

    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.COMPOSE_VERSION
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }


}

dependencies {
    api(project(Modules.UI))
    implementation(project(Modules.SPLASH))
    implementation(project(Modules.FEATURES_HOME))
    implementation(project(Modules.CLIENT_LOGIN))
    implementation(project(Modules.PRESENTATION))
    api(project(Modules.NETWORKING))
    api(project(Modules.DOMAIN))

    implementation(Dependencies.COIL_COMPOSE)

//    implementation(Dependencies.STDLIB)
    implementation(Dependencies.COREKTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.ACTIVITY_COMPOSE)

    // Compose dependencies
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_VIEWMODEL)
    implementation(Dependencies.COMPOSE_NAVIGATION)
    implementation(Dependencies.COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED)
    implementation(Dependencies.COMPOSE_HILT_NAVIGATION)

    //HILT
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    implementation(Dependencies.HILT_VIEW_MODEL)
    kapt(Dependencies.HILT_COMPILER)

    //RETROFIT
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)


    //TEST
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.JUNIT_EXT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
    androidTestImplementation(Dependencies.COMPOSE_UI_TEST)
    androidTestImplementation(Dependencies.COMPOSE_UI_TOOLING)

    // Import the BoM for the Firebase platform
    implementation(platform(Dependencies.FIREBASE_BOM))
    // FirebaseUI for Firebase Auth
    implementation(Dependencies.FIREBASE_UI_AUTH)

    implementation(Dependencies.FACEBOOK_ANDROID_SDK)
}

