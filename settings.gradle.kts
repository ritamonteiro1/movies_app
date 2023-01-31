pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven { url = uri("https://jitpack.io")}
    }
}

rootProject.name = "MoviesApp"
include(
    ":app",
    ":core",
    ":data",
    ":di",
    ":navigation",
    ":featurepopularmovies",
    ":featuresimilarmovies",
    ":designsystem"
)
