package vhumeniuk.notesapp.dagger.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import vhumeniuk.notesapp.database.NoteDao
import vhumeniuk.notesapp.database.NotesDatabase
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun notesDatabase(context: Context): NotesDatabase {
        return Room.databaseBuilder(context, NotesDatabase::class.java, NotesDatabase.NAME).build()
    }

    @Singleton
    @Provides
    fun noteDao(database: NotesDatabase): NoteDao {
        return database.noteDao()
    }
}