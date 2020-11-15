import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("android.extensions")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

group = "id.codepresso.cariosnews"
version = AppVersion.name

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependency.kotlinxSerializationCore)

                // Database
                implementation(Dependency.sqldelightRuntime)

                // Coroutines
                implementation(Dependency.coroutinesCore)

                // HTTP
                implementation(Dependency.ktorCore)
                implementation(Dependency.ktorJson)
                implementation(Dependency.ktorSerialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.android.material:material:1.2.0")

                // Database
                implementation(Dependency.sqldelightAndroid)

                // HTTP
                implementation(Dependency.ktorAndroid)

                // Lifecycle
                implementation(Dependency.lifecycleExtension)
                implementation(Dependency.lifecycleViewModelKtx)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.12")
            }
        }
        val iosMain by getting {
            dependencies {
                // Database
                implementation(Dependency.sqldelightNative)

                // HTTP
                implementation(Dependency.ktorIOS)
            }
        }
        val iosTest by getting
    }
}

sqldelight {
    database("CariosNewsDatabase") {
        packageName = "id.codepresso.cariosnews.shared.sql"
        sourceFolders = listOf("sqldelight")
    }
}

android {
    compileSdkVersion(AndroidVersion.target)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidVersion.minimum)
        targetSdkVersion(AndroidVersion.target)
        versionCode = AppVersion.code
        versionName = AppVersion.name
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}