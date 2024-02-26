rootProject.name = "kotlin-spring"

dependencyResolutionManagement {
    versionCatalogs {
        create("runtime") {
            version("postgresql","42.7.2")

            library("postgresql","org.postgresql", "postgresql").versionRef("postgresql")
        }
        create("libs") {
            version("exposed", "0.47.0")

            library("exposed-core", "org.jetbrains.exposed", "exposed-core").versionRef("exposed")
            library("exposed-dao", "org.jetbrains.exposed", "exposed-dao").versionRef("exposed")
            library("exposed-jdbc", "org.jetbrains.exposed", "exposed-jdbc").versionRef("exposed")
        }
        create("testLibs"){
            version("testcontainers", "1.18.3")
            version("kotest", "5.8.0")
            version("kotest-testcontainers", "2.0.2")
            version("kotest-spring", "1.1.3")

            library("testcontainers-junit", "org.testcontainers", "junit-jupiter").versionRef("testcontainers")
            library("testcontainers-postgresql", "org.testcontainers", "postgresql").versionRef("testcontainers")
            library("kotest-testcontainers", "io.kotest.extensions", "kotest-extensions-testcontainers").versionRef("kotest-testcontainers")
            library("kotest-spring", "io.kotest.extensions", "kotest-extensions-spring").versionRef("kotest-spring")
            library("kotest-assertions", "io.kotest", "kotest-assertions-core").versionRef("kotest")
            library("kotest-junit5", "io.kotest", "kotest-runner-junit5-jvm").versionRef("kotest")
        }
    }
}