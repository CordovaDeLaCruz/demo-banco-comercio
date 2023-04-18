plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

group = "com.banco.demo.configuration"
version = "SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

gradlePlugin {
    plugins.register("configuration") {
        id = "configuration"
        implementationClass = "com.banco.demo.configuration.ConfigurationPlugin"
    }
}

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()

}

dependencies {
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.2.0")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.0.4")
}


