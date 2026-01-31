plugins {
    id("java")
    id("application")
}

group = "net.kazakov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.processing:core:3.3.7")
}

