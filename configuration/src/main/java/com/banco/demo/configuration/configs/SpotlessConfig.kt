package com.banco.demo.configuration.configs

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import com.diffplug.gradle.spotless.SpotlessExtension
import java.util.*
import java.util.Calendar.YEAR

object SpotlessConfig {
    fun apply(target: Project) {

        target.configure<SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                ktlint()
                licenseHeader("/* Banco Demo 2023 ${Calendar.getInstance().get(YEAR)} */")
            }
            kotlinGradle {
                target("**/*.gradle.kts")
                ktlint()
            }
        }
    }
}