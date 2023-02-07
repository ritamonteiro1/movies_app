plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = Android.COMPILE
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION
    namespace = AppConfig.APPLICATION_ID

    defaultConfig {
        minSdk = Android.MIN
        targetSdk = Android.TARGET
        testInstrumentationRunner = Android.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
    implementation(Libs.KOTLIN_STD_VERSION)
    coroutines()
    retrofit()
    implementation(Libs.HTTP_INTERCEPTOR)
    room()
    androidTestImplementation(Libs.JUNIT_EXT)
    androidTestImplementation(Libs.ESPRESSO)
    testImplementation(Libs.JUNIT4)
    testImplementation(Libs.MOCKK)
    implementation(project(":featurepopularmovies"))
    implementation(project(":featuresimilarmovies"))
    implementation(project(":core"))
}