plugins {
    kotlin("jvm") version "2.0.21"

    // contractk4k
    id("io.freefair.aspectj.post-compile-weaving") version "8.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    // contractk4k
    maven { url = uri("https://jitpack.io") }
}

dependencies {

    // contract4k
    implementation("org.aspectj:aspectjrt:1.9.21")
    implementation(kotlin("reflect"))
    aspect("com.github.monorail-team:contract4k:v1.0.0")
}