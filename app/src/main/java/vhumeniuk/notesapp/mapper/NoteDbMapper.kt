package vhumeniuk.notesapp.mapper

import vhumeniuk.notesapp.database.NoteDbEntity
import vhumeniuk.notesapp.domain.Note
import java.util.*
import javax.inject.Inject

class NoteDbMapper @Inject constructor(): BaseMapper<NoteDbEntity, Note>() {

    override fun map(base: NoteDbEntity): Note {
        return Note(base.id, base.text, Date(base.lastEdit))
    }

    override fun mapBack(entity: Note): NoteDbEntity {
        return NoteDbEntity(entity.id, entity.text, entity.lastEdit.time)
    }
}