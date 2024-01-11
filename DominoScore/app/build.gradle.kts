plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
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
        vectorDrawables {
            useSupportLibrary = true
        }
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
    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
    buildFeatures {
        viewBinding = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1,DEPENDENCIES,LICENSE,NOTICE,NOTICE.txt,LICENSE.txt,LICENSE.md}"
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    //Core
    implementation(Libraries.Core.kotlinStd)
    implementation(Libraries.Core.coroutines)
    implementation(Libraries.Core.coroutinesCore)
    implementation(Libraries.Core.viewmodel)
    implementation(Libraries.Core.livedata)
    implementation(Libraries.Core.lifecycle)
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

    //UI
    implementation(Libraries.UI.coreKtx)
    implementation(Libraries.UI.appcompat)
    implementation(Libraries.UI.material)
    implementation(Libraries.UI.constraintlayout)
    implementation(Libraries.UI.navigationFragment)
    implementation(Libraries.UI.navigation)

    //Unit Tests
    testImplementation(Libraries.Test.core)
    testImplementation(Libraries.Test.coreTesting)
    testImplementation(Libraries.Test.junit)
    testImplementation(Libraries.Test.junitExt)
    testImplementation(Libraries.Test.truth)
    testImplementation(Libraries.Test.mockk)
    testImplementation(Libraries.Test.espresso)
    testImplementation(Libraries.Test.coroutines)
    kaptTest("com.google.dagger:hilt-android-compiler:2.48")

    //Instrumented Tests
    androidTestImplementation(Libraries.Test.junitExt)
    androidTestImplementation(Libraries.Test.runner)
    androidTestImplementation(Libraries.Test.rules)
    androidTestImplementation(Libraries.Test.mockk)
    androidTestImplementation(Libraries.Test.espresso)
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.44")
}