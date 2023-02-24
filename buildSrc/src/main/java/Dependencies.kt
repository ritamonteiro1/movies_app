import org.gradle.api.JavaVersion

object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_PARCELIZE = "kotlin-parcelize"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val KOTLIN = "kotlin"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
}

object AppConfig {
    const val APPLICATION_ID = "com.example.moviesapp"
    const val BUILD_TOOLS_VERSION = "30.0.3"
}

object Android {
    const val MIN = 21
    const val COMPILE = 33
    const val TARGET = COMPILE
    const val JVM_TARGET = "1.8"
    const val APP_VERSION_CODE = 1
    const val APP_VERSION_NAME = "1.0"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object AndroidCompileOptions {
    val SOURCE_COMPATIBILITY = JavaVersion.VERSION_1_8
    val TARGET_COMPATIBILITY = JavaVersion.VERSION_1_8
}