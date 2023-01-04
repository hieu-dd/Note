package com.example.note.di

import androidx.room.Room
import com.example.note.data.data_source.NoteDataBase
import org.koin.dsl.module

val testModule = module {
    single{
        Room.inMemoryDatabaseBuilder(
            get(),
            NoteDataBase::class.java,
        ).allowMainThreadQueries().build()
    }
}
