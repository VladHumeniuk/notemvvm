package vhumeniuk.notesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NoteDbEntity::class), version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    companion object {
        const val NAME = "NOTES_DATABASE"
    }

    abstract fun noteDao(): NoteDao
}