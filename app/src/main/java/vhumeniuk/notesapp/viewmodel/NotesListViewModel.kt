package vhumeniuk.notesapp.viewmodel

import androidx.lifecycle.ViewModel
import vhumeniuk.notesapp.facade.NotesFacade
import javax.inject.Inject

class NotesListViewModel @Inject constructor(
    private val notesFacade: NotesFacade
): ViewModel() {

    val notes = notesFacade.getAllNotes()
}