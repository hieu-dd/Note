package com.example.note

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.note.presentation.MainActivity
import com.example.note.presentation.MainScreen
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Before
import org.junit.Rule

abstract class BaseAndroidTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            MainScreen()
        }
    }
}
