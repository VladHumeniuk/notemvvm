package vhumeniuk.notesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.facade.NotesFacade
import java.util.*
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(
        private val notesFacade: NotesFacade
): ViewModel() {

    private val _note = MutableLiveData<Note>()

    val note: LiveData<Note> = _note

    fun loadNote(noteId: String) {
        viewModelScope.launch {
           _note.value = notesFacade.getNote(noteId)
        }
    }

    fun saveNote(text: String) {
        viewModelScope.launch {
            notesFacade.saveNote(Note(_note.value!!.id, text, Date()))
        }
    }
}