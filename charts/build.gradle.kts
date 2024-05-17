plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

extra["COMPOSE_CHARTS_ARTIFACT_ID"] = "compose-charts"
extra["COMPOSE_CHARTS_VERSION"] = "0.1.2"
extra["COMPOSE_CHARTS_POM_DESCRIPTION"] =
    "compose-charts: Simple Jetpack Compose Charts for multi-platform. Including Android, Web, Desktop."

// apply from : 'publish_compose_charts.gradle'

android {
    namespace = "me.bytebeats.views.charts"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
//        targetSdk = 34
//        testOptions {
//            targetSdk = 34
//        }

        lint {
            targetSdk = 34
        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.ktCompilerExt.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    debugImplementation(libs.androidx.ui.tooling)
}
