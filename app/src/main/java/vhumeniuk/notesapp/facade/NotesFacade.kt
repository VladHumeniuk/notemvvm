package vhumeniuk.notesapp.facade

import androidx.lifecycle.LiveData
import vhumeniuk.notesapp.domain.Note

interface NotesFacade {

    fun getAllNotes(): LiveData<List<Note>>
}