package com.example.note.di

import android.app.Application
import androidx.room.Room
import com.example.note.data.data_source.NoteDataBase
import com.example.note.data.repository.LocalNoteRepositoryImpl
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDataBase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDataBase::class.java
        ).allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository {
        return LocalNoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}
