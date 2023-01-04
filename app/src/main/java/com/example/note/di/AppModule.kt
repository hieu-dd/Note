package com.example.note.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.note.data.data_source.NoteDataBase
import com.example.note.data.repository.LocalNoteRepositoryImpl
import com.example.note.domain.repository.NoteRepository
import com.example.note.domain.use_case.AddNote
import com.example.note.domain.use_case.DeleteNote
import com.example.note.domain.use_case.GetNote
import com.example.note.domain.use_case.GetNotes
import com.example.note.domain.use_case.NoteUseCases
import com.example.note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.note.presentation.notes.NotesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<NoteDataBase> {
        Room.databaseBuilder(
            get<Context>(),
            NoteDataBase::class.java,
            "note_db"
        ).allowMainThreadQueries().build()
    }

    single<NoteRepository> {
        LocalNoteRepositoryImpl(get<NoteDataBase>().noteDao)
    }

    single {
        NoteUseCases(
            getNotes = GetNotes(get()),
            deleteNote = DeleteNote(get()),
            getNote = GetNote(get()),
            addNote = AddNote(get())
        )
    }

    viewModel {
        NotesViewModel(get())
    }
    viewModel {
        AddEditNoteViewModel(get(), get())
    }
}