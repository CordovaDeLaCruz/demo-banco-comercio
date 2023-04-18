import com.banco.demo.configuration.constants.AndroidBuildConfig
import com.banco.demo.configuration.constants.Dependencies
import com.banco.demo.configuration.constants.Modules

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = AndroidBuildConfig.COMPILE_SDK

}

dependencies {
    implementation(project(Modules.CONSTANTS))
    implementation(Dependencies.COREKTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.COROUTINES_CORE)
    testImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.JUNIT_EXT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
}
