package com.example.note.di

import android.app.Application
import androidx.room.Room
import com.example.note.data.data_source.NoteDataBase
import com.example.note.data.repository.LocalNoteRepositoryImpl
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.use_case.AddNote
import com.example.note.domain.use_case.DeleteNote
import com.example.note.domain.use_case.GetNote
import com.example.note.domain.use_case.GetNotes
import com.example.note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            "note_db"
        )
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataBase: NoteDataBase): NoteRepository {
        return LocalNoteRepositoryImpl(dataBase.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(noteRepository),
            deleteNote = DeleteNote(noteRepository),
            getNote = GetNote(noteRepository),
            addNote = AddNote(noteRepository)
        )
    }
}