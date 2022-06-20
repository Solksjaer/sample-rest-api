val lombookVersion = "1.18.24"
val springBootVersion = "2.7.0"

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

    java
    `maven-publish`
    jacoco
}

group = "org.example"
version = "1.0-SNAPSHOT"
description = "sample-rest-api"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-dependencies:$springBootVersion")
    implementation("org.apache.commons:commons-lang3:12.0")

    // Test
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Lombok
    compileOnly("org.projectlombok:lombok:$lombookVersion")
    annotationProcessor("org.projectlombok:lombok:$lombookVersion")
    testCompileOnly("org.projectlombok:lombok:$lombookVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombookVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation("org.assertj:assertj-core:3.23.1")
    //testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

sourceSets {
    main {
        java {
            srcDir("$buildDir/generate-resources/main")
        }
    }
}

jacoco {
    toolVersion = "0.8.7"
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
        html.outputLocation.set(file("$buildDir/jacocoHtml"))
    }
}

tasks.named("test") {
    finalizedBy("jacocoTestReport")
}