package vhumeniuk.notesapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_db_table")
class NoteDbEntity(
    @PrimaryKey
    val id: String,
    val text: String,
    val lastEdit: Long
)