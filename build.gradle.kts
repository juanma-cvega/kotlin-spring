import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4" apply true
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "com.jusoft"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(libs.exposed.dao)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)

    runtimeOnly(runtime.postgresql)

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation(testLibs.testcontainers.postgresql)
    testImplementation(testLibs.testcontainers.junit)
    testImplementation(testLibs.kotest.testcontainers)
    testImplementation(testLibs.kotest.junit5)
    testImplementation(testLibs.kotest.assertions)
    testImplementation(testLibs.kotest.spring)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    this.testLogging {
        this.showStandardStreams = true
    }
    useJUnitPlatform()
}
