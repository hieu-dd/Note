package com.example.note

import android.app.Application
import com.example.note.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class NoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NoteApp)
            modules(appModule)
        }
    }
}