import com.banco.demo.configuration.constants.AndroidBuildConfig
import com.banco.demo.configuration.constants.Dependencies
import com.banco.demo.configuration.constants.Modules


plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = AndroidBuildConfig.COMPILE_SDK
    defaultConfig {
        minSdk = AndroidBuildConfig.MIN_SDK
        targetSdk = AndroidBuildConfig.TARGET_SDK
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = AndroidBuildConfig.JVM_TARGET
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=kotlin.RequiresOptIn"
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
    implementation(project(Modules.NETWORKING))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.SOCIAL_NETWORK))
    implementation(project(Modules.FEATURES))
    api(project(Modules.CONSTANTS))

    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.COMPOSE_HILT_NAVIGATION)

    // Compose dependencies
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_VIEWMODEL)
    implementation(Dependencies.COMPOSE_NAVIGATION)
    implementation(Dependencies.COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED)


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
}
