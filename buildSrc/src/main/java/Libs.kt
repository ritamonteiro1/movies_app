import org.gradle.kotlin.dsl.DependencyHandlerScope

object ClasspathDependenciesLibs {
    const val ANDROID_GRADLE_PLUGIN =
        "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
    const val NAV_SAFE_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAV_SAFE_ARGS}"
}

fun DependencyHandlerScope.androidx() {
    "implementation"("androidx.appcompat:appcompat:${Versions.APP_COMPAT}")
    "implementation"("androidx.core:core-ktx:${Versions.CORE_KTX}")
    "implementation"("androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}")
    "implementation"("com.google.android.material:material:${Versions.MATERIAL_DESIGN}")
}

fun DependencyHandlerScope.retrofit() {
    "implementation"("com.squareup.retrofit2:retrofit:${Versions.RETROFIT}")
}

fun DependencyHandlerScope.okHttpInterceptor() {
    "implementation"("com.squareup.okhttp3:logging-interceptor:${Versions.HTTP_INTERCEPTOR}")
}

fun DependencyHandlerScope.gson() {
    "implementation"("com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}")
}

fun DependencyHandlerScope.coroutines() {
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}")
    "implementation"("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}")
    "testImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}")
}

fun DependencyHandlerScope.koin() {
    "implementation"("io.insert-koin:koin-android:${Versions.KOIN}")
}

fun DependencyHandlerScope.room() {
    "implementation"("androidx.room:room-runtime:${Versions.ROOM}")
    "implementation"("androidx.room:room-ktx:${Versions.ROOM}")
    "kapt"("androidx.room:room-compiler:${Versions.ROOM}")
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
    "implementation"("com.google.accompanist:accompanist-systemuicontroller:${Versions.SYSTEM_UI_CONTROLLER_COMPOSE}")
    "implementation"("io.coil-kt:coil-compose:${Versions.COIL_COMPOSE_VERSION}")
}

fun DependencyHandlerScope.lifecycle() {
    "implementation"("androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}")
    "implementation"("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}")
}

fun DependencyHandlerScope.navigation() {
    "implementation"("androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_FRAGMENT}")
    "implementation"("androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_FRAGMENT}")
}

fun DependencyHandlerScope.paging() {
    "implementation"("androidx.paging:paging-runtime:${Versions.PAGING}")
    "implementation"("androidx.paging:paging-runtime:${Versions.PAGING}")
    "implementation"("androidx.paging:paging-compose:${Versions.PAGING_COMPOSE}")
}

fun DependencyHandlerScope.lottie() {
    "implementation"("com.airbnb.android:lottie:${Versions.LOTTIE}")
}

fun DependencyHandlerScope.glide() {
    "implementation"("com.github.bumptech.glide:glide:${Versions.GLIDE}")
}

fun DependencyHandlerScope.jUnit() {
    "testImplementation"("junit:junit:${Versions.JUNIT4_VERSION}")
    "androidTestImplementation"("androidx.test.ext:junit:${Versions.JUNIT_EXT_VERSION}")
}

fun DependencyHandlerScope.espresso() {
    "androidTestImplementation"("androidx.test.espresso:espresso-core:${Versions.ESPRESSO_VERSION}")
}

fun DependencyHandlerScope.mockK() {
    "testImplementation"("io.mockk:mockk:${Versions.MOCKK_VERSION}")
}