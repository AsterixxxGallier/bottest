import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    application
}

group = "me.asterixxx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kordlib/Kord")
}

dependencies {
    implementation("com.gitlab.kordlib.kord:kord-core:0.6.3")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

tasks.register("stage") {
    dependsOn("build")
}

application {
    mainClassName = "MainKt"
}