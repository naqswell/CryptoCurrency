plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.feature_coin_details"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":network-coinstats"))

    implementation(platform(libs.compose.bom))
    implementation(libs.coil)
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.navigationCompose)
    implementation(libs.navigationCompose.hilt)
    implementation(libs.kotlin.serialization)
    implementation(libs.kotlin.serialization.converter)
    implementation(libs.retrofit)
    implementation(libs.timber)
    implementation(project(mapOf("path" to ":network-coinstats")))

    ksp(libs.hilt.compiler)

    coreLibraryDesugaring(libs.desugar)
}