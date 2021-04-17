package vhumeniuk.notesapp.facade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vhumeniuk.notesapp.domain.Note
import javax.inject.Inject

class NotesMockFacade @Inject constructor(): NotesFacade {

    override fun getAllNotes(): LiveData<List<Note>> {
        val list = listOf(Note("1", "note number 1"), Note("2", "note number 2"), Note("3", "note number 3"), Note("4", "note number 4"))
        return MutableLiveData<List<Note>>(list)
    }
}