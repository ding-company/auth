import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("io.spring.dependency-management") version "1.1.0"
    id("org.springframework.boot") version Dependency.springBootVersion
    kotlin("jvm") version Dependency.kotlinVersion
    kotlin("plugin.spring") version Dependency.kotlinVersion
    kotlin("kapt") version Dependency.kotlinVersion
    kotlin("plugin.jpa") version Dependency.kotlinVersion
    id("org.jetbrains.kotlin.plugin.allopen") version Dependency.kotlinVersion
    id("org.jetbrains.kotlin.plugin.noarg") version Dependency.kotlinVersion

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
    testImplementation ("junit:junit:4.13.2")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.hibernate:hibernate-core:5.5.6.Final")
    implementation("mysql:mysql-connector-java:${Dependency.mySQLConnectorVersion}")
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


noArg {
    annotation("javax.persistence.Entity")
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}