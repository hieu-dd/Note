package com.example.note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note Where id=:id")
    fun getNoteById(id: Int): Note?

    @Insert(onConflict = REPLACE)
    fun insertNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}