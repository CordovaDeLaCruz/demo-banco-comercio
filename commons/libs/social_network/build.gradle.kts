import com.banco.demo.configuration.constants.AndroidBuildConfig
import com.banco.demo.configuration.constants.Dependencies
import com.banco.demo.configuration.constants.Modules

plugins {
    id("com.android.library")
    id("kotlin-android")
}



android {

    compileSdk = AndroidBuildConfig.COMPILE_SDK


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

    implementation(project(Modules.UI))

    // Compose dependencies
    implementation(Dependencies.COMPOSE_VIEWMODEL)
    implementation(Dependencies.COMPOSE_NAVIGATION)
    implementation(Dependencies.COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED)
    implementation(Dependencies.COMPOSE_HILT_NAVIGATION)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_CONSTRAINT_LAYOUT)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)


    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.JUNIT_EXT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)

    // Import the BoM for the Firebase platform
    implementation(platform(Dependencies.FIREBASE_BOM))
    // FirebaseUI for Firebase Auth
    implementation(Dependencies.FIREBASE_UI_AUTH)
    // Also declare the dependency for the Google Play services library and specify its version
    implementation(Dependencies.PLAY_SERVICES_AUTH)
    implementation(Dependencies.FIREBASE_AUTH)
    implementation(Dependencies.FIREBASE_ANALYTICS)
    implementation(Dependencies.FACEBOOK_ANDROID_SDK)
}