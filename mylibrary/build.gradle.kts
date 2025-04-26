plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.dokka)
    id("jacoco")
}

android {
    namespace = "com.nilutopia.mylibrary"
    compileSdk = 35

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                //get the file pointing to the aar file
                val file = layout.buildDirectory.file("outputs/aar/${project.name}-release.aar")
                artifact(file)
            }
            groupId = "com.nilutopia"
            artifactId = "mylibrary"
            version = "0.0.1"
        }
    }
    repositories {
        maven {
            name = "github"
            url = uri("https://maven.pkg.github.com/NilUtopia/JokeMe")
            credentials {
                username = System.getenv("GITHUB_USER")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

val exclusions = listOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*",
    "**/Fake*.*",
)

tasks.withType(Test::class) {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}

tasks.register<JacocoReport>("jacocoCodeCoverage") {
    group = "Reporting"
    description = "Generate Jacoco code coverage report"
    reports {
        csv.required.set(true)
        html.required.set(true)
    }
    sourceDirectories.setFrom(layout.projectDirectory.dir("src/main"))
    classDirectories.setFrom(
        files(
            fileTree(layout.buildDirectory.dir("intermediates/javac/release")) {
                exclude(exclusions)
            },
            fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/release")) {
                exclude(exclusions)
            }
        ))
    executionData.setFrom(
        files(
            fileTree(layout.buildDirectory) { include(listOf("jacoco/**/*.exec")) }
        ))
}