package com.example.note.domain.use_case

import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository

data class DeleteNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}