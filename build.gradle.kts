buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependency.androidGradle)
        classpath(Dependency.kotlinGradle)
        classpath(Dependency.kotlinSerialization)
        classpath(Dependency.sqldelightGradle)
    }
}

group = "id.codepresso.cariosnews"
version = AppVersion.name

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()

        // koin
        maven(url = "https://dl.bintray.com/ekito/koin")
    }
}