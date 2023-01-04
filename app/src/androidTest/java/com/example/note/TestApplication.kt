package com.example.note

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.example.note.di.appModule
import com.example.note.di.testAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
            modules(testAppModule)
        }
    }
}