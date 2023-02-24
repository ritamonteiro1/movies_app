plugins {
    id(BuildPlugins.KOTLIN)
}

apply {
    from("../config/detekt/detekt.gradle")
}