plugins {
    id("org.jetbrains.kotlin.jvm") version ("1.4.31")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")

    implementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
}
