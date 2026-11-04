package com.avanade.carteiradigital

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(BuildConfig.APPLICATION_ID, appContext.packageName)
    }

    @Test
    fun appLabelMatchesEnvironment() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val expectedLabel = when (BuildConfig.ENVIRONMENT) {
            "dev" -> "Carteira Digital (DEV)"
            "stg" -> "Carteira Digital (STG)"
            "prod" -> "Carteira Digital"
            else -> error("Unknown environment: ${BuildConfig.ENVIRONMENT}")
        }
        val actualLabel = appContext.applicationInfo.loadLabel(appContext.packageManager).toString()
        assertEquals(expectedLabel, actualLabel)
    }
}