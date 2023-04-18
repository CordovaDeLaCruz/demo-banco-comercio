package com.banco.demo.configuration.tasks

import org.gradle.api.Project
import org.gradle.api.tasks.Exec
import org.gradle.kotlin.dsl.register
import java.io.File
import org.apache.tools.ant.taskdefs.condition.Os

object RootTasks {

    const val WINDOWS_COMMAND = """#!/bin/bash
echo "Running spotless check"
./gradlew spotlessApplyAll detekt ktlintCheck 
"""
    const val MAC_COMMAND = """
#!/bin/bash
echo "Running spotless check"
./gradlew spotlessApplyAll detekt ktlintCheck 
"""

    fun apply(target: Project) {
        createSpotlessTask(target)
        devToolsInit(target)
    }

    fun createSpotlessTask(target: Project) {
        target.tasks.register("spotlessApplyAll") {
            target.subprojects.forEach {
                dependsOn(
                    it.tasks.getByName("spotlessKotlinApply"),
                    it.tasks.getByName("spotlessKotlinGradleApply")
                )
            }
        }
    }

    fun devToolsInit(target: Project) {
        target.tasks.register<Exec>("createCommitHook") {
            workingDir(target.projectDir)
            val gitHooksDirectory = target.file("${target.rootDir}/.git/hooks/")
            if (!gitHooksDirectory.exists()) gitHooksDirectory.mkdirs()

            if (Os.isFamily(Os.FAMILY_WINDOWS)) {
                File("${target.rootDir}/.git/hooks", "pre-commit").writeText(WINDOWS_COMMAND)
                commandLine( "./config/git/windows.bat")
            }else{
                File("${target.rootDir}/.git/hooks", "pre-commit").writeText(MAC_COMMAND)
                commandLine( "./config/git/mac.bat")
            }
        }

        target.tasks.register("initProject") {
            dependsOn("createCommitHook")
        }
    }

}