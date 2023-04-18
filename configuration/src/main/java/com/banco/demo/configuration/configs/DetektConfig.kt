package com.banco.demo.configuration.configs

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.gradle.kotlin.dsl.configure

object DetektConfig {
    fun apply(target: Project){
        target.configure<DetektExtension>{
            buildUponDefaultConfig = true
            allRules = false
            config = target.files("${target.rootDir}/config/detekt/detekt.yml")
        }
        target.tasks.withType<Detekt>().configureEach {
            reports {
                html.required.set(true)
                xml.required.set(true)
                txt.required.set(true)
                sarif.required.set(true)
            }
        }
    }
}