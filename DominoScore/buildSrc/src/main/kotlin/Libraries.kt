object Libraries {

    object Core {
        val coroutines: String = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Core.coroutines}"
        val coroutinesCore: String = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Core.coroutinesCore}"
        val viewmodel: String = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Core.viewmodel}"
        val livedata: String = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Core.livedata}"
        val kotlinStd: String = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Core.kotlinStd}"
        val lifecycle: String = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Core.lifecycle}"
    }

    object UI {
        val coreKtx: String = "androidx.core:core-ktx:${Versions.UI.core}"
        val appcompat: String = "androidx.appcompat:appcompat:${Versions.UI.appcompat}"
        val material: String = "com.google.android.material:material:${Versions.UI.material}"
        val constraintlayout: String =
            "androidx.constraintlayout:constraintlayout:${Versions.UI.appcompat}"
        val navigation: String = "androidx.navigation:navigation-ui-ktx:${Versions.UI.navigation}"
        val navigationFragment: String =
            "androidx.navigation:navigation-fragment-ktx:${Versions.UI.navigation}"
    }

    object Test {
        val core: String = "androidx.test:core:${Versions.Test.core}"
        val coreTesting: String = "androidx.arch.core:core-testing:${Versions.Test.coreTesting}"
        val coroutines: String = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.coroutines}"
        val junit: String = "junit:junit:${Versions.Test.junit}"
        val junitExt: String = "androidx.test.ext:junit:${Versions.Test.junitExt}"
        val runner: String = "androidx.test:runner:${Versions.Test.runner}"
        val rules: String = "androidx.test:rules:${Versions.Test.rules}"
        val truth: String = "androidx.test.ext:truth:${Versions.Test.truth}"
        val mockk: String = "io.mockk:mockk:${Versions.Test.mockk}"
        val espresso: String = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
    }
}