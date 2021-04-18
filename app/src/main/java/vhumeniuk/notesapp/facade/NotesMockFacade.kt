package vhumeniuk.notesapp.facade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import vhumeniuk.notesapp.domain.Note
import java.util.*
import javax.inject.Inject

class NotesMockFacade @Inject constructor(): NotesFacade {

    private val list = mutableMapOf("1" to Note("1", "note number 1", Date()),
            "2" to Note("2", "note number 2", Date()),
            "3" to Note("3", "note number 3", Date()),
            "4" to Note("4", "note number 4", Date()))

    private val liveList = MutableLiveData<List<Note>>(list.values.toList())

    override fun getAllNotes(): LiveData<List<Note>> {
        return liveList
    }

    override suspend fun saveNote(note: Note) {
       list[note.id] = note
        liveList.value = list.values.toList()
    }

    override suspend fun getNote(id: String): Note {
         if (!list.containsKey(id)) {
            list[id] = Note(id, "", Date())
        }
        return list[id]!!
    }
}