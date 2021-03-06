/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.0/userguide/building_java_projects.html
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.4.31"

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:30.0-jre")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    api("io.kotlintest:kotlintest-core:3.4.2")
    api("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    api("io.kotlintest:kotlintest-assertions:3.4.2")

    api("io.mockk:mockk:1.10.3")

    api("org.junit.jupiter:junit-jupiter-api:5.7.0")
    api("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    api("org.junit.jupiter:junit-jupiter-params:5.7.0")
}

application {
    // Define the main class for the application.
    mainClass.set("boon.AppKt")
}
