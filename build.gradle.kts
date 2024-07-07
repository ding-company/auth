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
    id("io.gitlab.arturbosch.detekt") version "1.22.0"

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
//    implementation("org.springframework.boot:spring-boot-starter-security")

    // detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:${Dependency.mockkVersion}")
    testImplementation ("junit:junit:4.13.2")

    // JPA
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.hibernate:hibernate-core:5.5.6.Final")
    implementation("mysql:mysql-connector-java:${Dependency.mySQLConnectorVersion}")



    // Querydsl
    implementation("com.querydsl:querydsl-jpa:5.0.0:jakarta")
    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")

    runtimeOnly("com.h2database:h2")

}
detekt {
    autoCorrect = true
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