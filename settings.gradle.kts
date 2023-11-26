@file:Suppress("UnstableApiUsage")

include(":feature-coins-tracking-list")



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
    }
}

rootProject.name = "CryptoCurrency"
include(":app")
include(":core")
include(":feature-test")
include(":network-coinstats")
include(":cache-coins")
include(":feature-coin-details")
include(":feature-coins-list")