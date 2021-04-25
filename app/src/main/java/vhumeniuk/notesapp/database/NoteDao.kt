package vhumeniuk.notesapp.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_db_table ORDER BY lastEdit DESC")
    fun getLastUpdateDesc(): Flow<List<NoteDbEntity>>

    @Query("SELECT * FROM note_db_table WHERE id IS :id LIMIT 1")
    suspend fun getById(id: String): NoteDbEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: NoteDbEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: NoteDbEntity)
}