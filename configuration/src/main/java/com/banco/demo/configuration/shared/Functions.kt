package com.banco.demo.configuration.shared

import org.gradle.api.Project
import org.gradle.kotlin.dsl.maven

object Functions {
    fun applyCommonRepos(project: Project){
        project.repositories.apply {
            mavenCentral()
            google()
            maven(url = "https://jitpack.io" ){
//            content {
//                includeGroup("com.github.CanHub")
//            }
            }
        }
    }

    fun applyCommonPlugins(project: Project){
        project.plugins.apply("org.jlleitschuh.gradle.ktlint")
        project.plugins.apply("io.gitlab.arturbosch.detekt")
        project.plugins.apply("com.diffplug.spotless")
    }


}