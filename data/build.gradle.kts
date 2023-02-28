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
    coroutines()
    retrofit()
    okHttpInterceptor()
    room()
    paging()
    gson()
    jUnit()
    espresso()
    mockK()
    implementation(project(path = Modules.FEATURE_POPULAR_MOVIES))
    implementation(project(path = Modules.FEATURE_SIMILAR_MOVIES))
    implementation(project(path = Modules.CORE))
}