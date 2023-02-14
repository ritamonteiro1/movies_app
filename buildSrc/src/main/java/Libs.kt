import org.gradle.kotlin.dsl.DependencyHandlerScope

object ClasspathDependenciesLibs {
    const val ANDROID_GRADLE_PLUGIN =
        "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
    const val NAV_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAV_SAFE_ARGS_VERSION}"
}

object Libs {
    const val MATERIAL_DESIGN =
        "com.google.android.material:material:${Versions.MATERIAL_DESIGN_VERSION}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val KOTLIN_STD_VERSION =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_VERSION}"
    const val HTTP_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.HTTP_INTERCEPTOR}"
    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL_COMPOSE_VERSION}"
    const val SYSTEM_UI_COMPOSE =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.SYSTEM_UI_CONTROLLER_COMPOSE}"
    const val LEGACY_SUPPORT =
        "androidx.legacy:legacy-support-v4:${Versions.LEGACY_SUPPORT_VERSION}"
    const val JUNIT4 =
        "junit:junit:${Versions.JUNIT4_VERSION}"
    const val MOCKK =
        "io.mockk:mockk:${Versions.MOCKK_VERSION}"
    const val JUNIT_EXT =
        "androidx.test.ext:junit:${Versions.JUNIT_EXT_VERSION}"
    const val ESPRESSO =
        "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}"
    const val GLIDE =
        "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val LOTTIE =
        "com.airbnb.android:lottie:${Versions.GLIDE_VERSION}"
}

fun DependencyHandlerScope.androidx() {
    "implementation"("androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}")
    "implementation"("androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}")
}

fun DependencyHandlerScope.retrofit() {
    "implementation"("com.squareup.retrofit2:retrofit:${Versions.RETROFIT}")
    "implementation"("com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}")
}

fun DependencyHandlerScope.coroutines() {
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}")
    "testImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}")
}

fun DependencyHandlerScope.koin() {
    "implementation"("io.insert-koin:koin-androidx-scope:${Versions.KOIN_VERSION}")
    "implementation"("io.insert-koin:koin-androidx-viewmodel:${Versions.KOIN_VERSION}")
    "implementation"("io.insert-koin:koin-androidx-fragment:${Versions.KOIN_VERSION}")
}

fun DependencyHandlerScope.room() {
    "implementation"("androidx.room:room-runtime:${Versions.ROOM_VERSION}")
    "implementation"("androidx.room:room-ktx:${Versions.ROOM_VERSION}")
    "kapt"("androidx.room:room-compiler:${Versions.ROOM_VERSION}")
}

fun DependencyHandlerScope.compose() {
    "implementation"("androidx.compose.ui:ui:${Versions.COMPOSE}")
    "implementation"("androidx.compose.material:material:${Versions.COMPOSE}")
    "implementation"("androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}")
    "implementation"("androidx.activity:activity-compose:${Versions.COMPOSE}")
    "debugImplementation"("androidx.compose.ui:ui-tooling:${Versions.COMPOSE}")
    "implementation"("androidx.compose.foundation:foundation:${Versions.COMPOSE}")
    "implementation"("androidx.compose.ui:ui-tooling-preview:${Versions.COMPOSE}")
    "implementation"("androidx.compose.ui:ui:${Versions.COMPOSE}")
    "implementation"("androidx.compose.runtime:runtime-livedata:${Versions.COMPOSE}")
}

fun DependencyHandlerScope.lifecycle() {
    "implementation"("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}")
    "implementation"("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}")
}

fun DependencyHandlerScope.navigation() {
    "implementation"("androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}")
    "implementation"("androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}")
}

fun DependencyHandlerScope.paging() {
    "implementation"("androidx.paging:paging-runtime:${Versions.PAGING_VERSION}")
    "implementation"("androidx.paging:paging-runtime:${Versions.PAGING_VERSION}")
    "implementation"("androidx.paging:paging-compose:1.0.0-alpha17")
}