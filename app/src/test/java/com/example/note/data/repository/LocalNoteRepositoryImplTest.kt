package com.example.note.data.repository


import com.example.note.data.data_source.NoteDao
import com.example.note.domain.model.Note
import com.google.common.truth.Truth.assertThat
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)

class LocalNoteRepositoryImplTest {
    private lateinit var repo: LocalNoteRepositoryImpl

    @MockK
    private lateinit var noteDao: NoteDao
    @MockK
    private lateinit var mockNote: Note

    @Before
    fun setUp() {
        mockNote =  mockk()
        noteDao = mockk()
        repo = LocalNoteRepositoryImpl(noteDao)
    }

    @Test
    fun testGetNoteShouldReturnSameNoteDao() = runTest {
        every { noteDao.getAllNotes() } returns flow { emit(listOf(mockNote)) }
        val note = repo.getNotes().first()
        assertThat(note).isEqualTo(listOf(mockNote))
    }
}