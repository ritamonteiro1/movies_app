// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(ClasspathDependenciesLibs.ANDROID_GRADLE_PLUGIN)
        classpath(ClasspathDependenciesLibs.KOTLIN_GRADLE_PLUGIN)
        classpath(ClasspathDependenciesLibs.NAV_SAFE_ARGS)
    }
}

plugins {
    id(BuildPlugins.DETEKT).version(Versions.DETEKT)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}