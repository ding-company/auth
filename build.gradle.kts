import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version Dependency.springBootVersion
    kotlin("jvm") version Dependency.kotlinVersion
    kotlin("plugin.spring") version Dependency.kotlinVersion
    kotlin("kapt") version Dependency.kotlinVersion
}

java.sourceCompatibility = JavaVersion.toVersion(Dependency.targetJvmVersion)

repositories {
    google()
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Dependency.springCloudVersion}")
    }
}

apply(plugin = "kotlin-kapt")
dependencies {
    // MVC
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    testImplementation("io.mockk:mockk:${Dependency.mockkVersion}")

    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Dependency.targetJvmVersion
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }
}
