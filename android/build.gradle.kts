plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(AndroidSDKVersion.compile)
    defaultConfig {
        applicationId = "id.codepresso.cariosnews.android"
        minSdkVersion(AndroidSDKVersion.minimum)
        targetSdkVersion(AndroidSDKVersion.target)
        versionCode = AppVersion.code
        versionName = AppVersion.name
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(kotlin("stdlib", Versions.kotlin))
    implementation(Deps.material)
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.constraintLayout)
    implementation(Deps.Coroutines.core)
    implementation(Deps.Coroutines.android)
    implementation(Deps.picasso)
}