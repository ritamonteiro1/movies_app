// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { setUrl("https://jitpack.io") }
    }

    dependencies {
        classpath(ClasspathDependenciesLibs.ANDROID_GRADLE_PLUGIN)
        classpath(ClasspathDependenciesLibs.KOTLIN_GRADLE_PLUGIN)
        classpath(ClasspathDependenciesLibs.NAV_SAFE_ARGS)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { setUrl("https://jitpack.io") }
    }
}

plugins {
    id(BuildPlugins.DETEKT).version(Versions.DETEKT)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}