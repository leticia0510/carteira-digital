package com.avanade.carteiradigital

import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun environmentMatchesFlavor() {
        assertTrue(BuildConfig.ENVIRONMENT in setOf("dev", "stg", "prod"))
        assertEquals(BuildConfig.FLAVOR, BuildConfig.ENVIRONMENT)
    }

    @Test
    fun applicationIdMatchesEnvironment() {
        val expectedApplicationId = when (BuildConfig.ENVIRONMENT) {
            "dev" -> "com.avanade.carteiradigital.dev"
            "stg" -> "com.avanade.carteiradigital.stg"
            "prod" -> "com.avanade.carteiradigital"
            else -> error("Unknown environment: ${BuildConfig.ENVIRONMENT}")
        }
        assertEquals(expectedApplicationId, BuildConfig.APPLICATION_ID)
    }

    @Test
    fun versionSuffixMatchesEnvironment() {
        val expectedVersionName = when (BuildConfig.ENVIRONMENT) {
            "dev" -> "1.0-dev"
            "stg" -> "1.0-stg"
            "prod" -> "1.0"
            else -> error("Unknown environment: ${BuildConfig.ENVIRONMENT}")
        }
        assertEquals(expectedVersionName, BuildConfig.VERSION_NAME)
    }
}