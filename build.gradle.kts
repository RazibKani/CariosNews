buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.androidGradle)
        classpath(Deps.kotlinGradle)
        classpath(Deps.kotlinSerialization)
        classpath(Deps.SqlDelight.gradle)
    }
}

group = "id.codepresso.cariosnews"
version = AppVersion.name

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}