plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
}

android {
    compileSdk = Android.COMPILE
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = Android.MIN
        targetSdk = Android.TARGET
        versionCode = Android.APP_VERSION_CODE
        versionName = Android.APP_VERSION_NAME
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
    koin()
    implementation(project(path = ":di"))
    implementation(project(path = ":featurepopularmovies"))
    implementation(project(path = ":featuresimilarmovies"))
}