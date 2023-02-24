plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
}

apply {
    from("../config/detekt/detekt.gradle")
}

android {
    compileSdk = Android.COMPILE
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        minSdk = Android.MIN
        targetSdk = Android.TARGET
        testInstrumentationRunner = Android.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
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

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerVersion = "1.1.1"
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    androidx()
    koin()
    room()
    compose()
    navigation()
    coroutines()
    lifecycle()
    paging()
    jUnit()
    espresso()
    mockK()
    implementation(project(path = Modules.CORE))
    implementation(project(path = Modules.NAVIGATION))
    implementation(project(path = Modules.DESIGN_SYSTEM))
}