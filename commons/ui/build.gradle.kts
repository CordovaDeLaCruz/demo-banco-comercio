import com.banco.demo.configuration.constants.AndroidBuildConfig
import com.banco.demo.configuration.constants.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
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

    implementation(Dependencies.COREKTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.ACTIVITY_COMPOSE)

    // Coil
    implementation(Dependencies.COIL)
    implementation(Dependencies.COIL_COMPOSE)
    implementation(Dependencies.COIL_GIF)

    // Compose dependencies
    implementation(Dependencies.COMPOSE_VIEWMODEL)
    implementation(Dependencies.COMPOSE_NAVIGATION)
    implementation(Dependencies.COMPOSE_MATERIAL_COMPOSE_ICONS_EXTENDED)
    implementation(Dependencies.COMPOSE_HILT_NAVIGATION)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_CONSTRAINT_LAYOUT)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)

    //Calendar Dates
    implementation(Dependencies.CALENDAR_THREETENBP)


    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.JUNIT_EXT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
    androidTestImplementation(Dependencies.COMPOSE_UI_TEST)
    debugImplementation(Dependencies.COMPOSE_UI_TOOLING)
}



