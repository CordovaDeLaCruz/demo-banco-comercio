package com.banco.demo.configuration

import com.banco.demo.configuration.configs.DetektConfig
import com.banco.demo.configuration.configs.KtLintConfig
import com.banco.demo.configuration.configs.SpotlessConfig
import com.banco.demo.configuration.shared.Functions
import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigurationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.allprojects {
            Functions.applyCommonRepos(this)
            Functions.applyCommonPlugins(this)
            KtLintConfig.apply(this)
            DetektConfig.apply(this)
            SpotlessConfig.apply(this)
        }
    }
}





