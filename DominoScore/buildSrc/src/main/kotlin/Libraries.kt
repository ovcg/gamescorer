object Libraries {

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
        val junit: String = "junit:junit:${Versions.Test.junit}"
        val junitExt: String = "androidx.test.ext:junit:${Versions.Test.junitExt}"
        val runner: String = "androidx.test:runner:${Versions.Test.runner}"
        val rules: String = "androidx.test:rules:${Versions.Test.rules}"
        val truth: String = "androidx.test.ext:truth:${Versions.Test.truth}"
        val mockk: String = "io.mockk:mockk:${Versions.Test.mockk}"
        val espresso: String = "androidx.test.espresso:espresso-core:${Versions.Test.espresso}"
        val espressoIntents: String =
            "androidx.test.espresso:espresso-intents:${Versions.Test.espressoIntents}"
        val robolectric: String = "org.robolectric:robolectric:${Versions.Test.robolectric}"
        val orchestrator: String = "androidx.test:orchestrator:${Versions.Test.orchestrator}"
    }
}