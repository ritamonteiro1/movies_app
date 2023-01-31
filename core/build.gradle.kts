plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
}

android {
    compileSdk = Android.COMPILE
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION
    namespace = AppConfig.APPLICATION_ID

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(31)
        testInstrumentationRunner = Android.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = AndroidCompileOptions.SOURCE_COMPATIBILITY
        targetCompatibility = AndroidCompileOptions.TARGET_COMPATIBILITY
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = Android.JVM_TARGET
        }
    }
}

dependencies {
    androidx()
    implementation(Libs.MATERIAL_DESIGN)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.KOTLIN_STD_VERSION)
}