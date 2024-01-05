package com.ovcg.dominoscore.utils

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ovcg.dominoscore.MainActivity
import org.junit.Rule

abstract class BaseUITest {

    @get:Rule
    val mActivityRule = ActivityScenarioRule(MainActivity::class.java)

}