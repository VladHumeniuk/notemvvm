package vhumeniuk.notesapp.dagger.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import vhumeniuk.notesapp.NotesApplication
import javax.inject.Singleton

@Module
class GlobalModule {

    @Singleton
    @Provides
    fun notesApplication(app: Application): NotesApplication {
        return app as NotesApplication
    }

    @Singleton
    @Provides
    fun context(app: Application): Context {
        return app.applicationContext
    }
}