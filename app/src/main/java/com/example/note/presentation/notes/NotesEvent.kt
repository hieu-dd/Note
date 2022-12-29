package com.example.note.presentation.notes

import com.example.note.domain.model.Note
import com.example.note.domain.util.NoteOrder

sealed interface NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent
    data class DeleteNote(val note: Note) : NotesEvent
    object RestoreNote : NotesEvent
    object ToggleOrderSection : NotesEvent
}