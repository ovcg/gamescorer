plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Configs.applicationId
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {

    implementation(Libraries.UI.coreKtx)
    implementation(Libraries.UI.appcompat)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.constraintlayout)
    implementation(Libraries.UI.navigationFragment)
    implementation(Libraries.UI.navigation)

    //Unit Tests
    testImplementation(Libraries.Test.core)
    testImplementation(Libraries.Test.junit)
    testImplementation(Libraries.Test.junitExt)
    testImplementation(Libraries.Test.robolectric)
    testImplementation(Libraries.Test.truth)
    testImplementation(Libraries.Test.mockk)
    testImplementation(Libraries.Test.espresso)
    testImplementation(Libraries.Test.espressoIntents)

    //Instrumented Tests
    androidTestImplementation(Libraries.Test.core)
    androidTestImplementation(Libraries.Test.junit)
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.runner)
    androidTestImplementation(Libraries.Test.rules)
    androidTestImplementation(Libraries.Test.truth)
    androidTestImplementation(Libraries.Test.mockk)
    androidTestImplementation(Libraries.Test.espresso)
    androidTestUtil(Libraries.Test.orchestrator)
}