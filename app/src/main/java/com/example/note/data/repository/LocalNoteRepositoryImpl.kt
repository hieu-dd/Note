package com.example.note.data.repository

import com.example.note.data.data_source.NoteDao
import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class LocalNoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }
}