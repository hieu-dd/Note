package com.example.note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDataBase : RoomDatabase() {
    abstract val noteDao: NoteDao
}
