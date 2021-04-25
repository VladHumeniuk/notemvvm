package vhumeniuk.notesapp.facade

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.map
import vhumeniuk.notesapp.database.NoteDao
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.mapper.NoteDbMapper
import java.util.*
import javax.inject.Inject

class NotesDbFacade @Inject constructor(
    private val noteDao: NoteDao,
    private val noteDbMapper: NoteDbMapper
): NotesFacade {

    override fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.getLastUpdateDesc()
            .map { dbList ->
                val result = mutableListOf<Note>()
                for (dbNote in dbList) {
                    result.add(noteDbMapper.map(dbNote))
                }
                result
            }.asLiveData()
    }

    override suspend fun saveNote(note: Note) {
        noteDao.update(noteDbMapper.mapBack(note))
    }

    override suspend fun getNote(id: String): Note {
        return noteDbMapper.map(noteDao.getById(id))
    }

    override suspend fun createNote(id: String): Note {
        val note = Note(id, "", Date())
        noteDao.insert(noteDbMapper.mapBack(note))
        return note
    }
}