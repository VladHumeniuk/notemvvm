package vhumeniuk.notesapp.facade

import androidx.lifecycle.LiveData
import vhumeniuk.notesapp.domain.Note

interface NotesFacade {

    fun getAllNotes(): LiveData<List<Note>>

    suspend fun saveNote(note: Note)

    suspend fun getNote(id: String): Note
}