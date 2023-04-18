package com.banco.demo.configuration.configs

import org.gradle.api.Project
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.gradle.kotlin.dsl.configure

object KtLintConfig {
    fun apply(target: Project){
        target.configure<KtlintExtension> {
            version.set("0.42.1")
            debug.set(false)
            verbose.set(true)
            android.set(true)
            outputToConsole.set(true)
            outputColorName.set("RED")
            ignoreFailures.set(false)
            enableExperimentalRules.set(true)
            filter {
                exclude("**/generated/**")
                include("**/java/**")
            }
        }

    }
}