package com.example.note.domain.use_case

import com.example.note.domain.model.Note
import com.example.note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}