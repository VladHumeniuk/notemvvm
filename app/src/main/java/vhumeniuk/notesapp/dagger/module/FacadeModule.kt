package vhumeniuk.notesapp.dagger.module

import dagger.Binds
import dagger.Module
import vhumeniuk.notesapp.facade.NotesDbFacade
import vhumeniuk.notesapp.facade.NotesFacade
import javax.inject.Singleton

@Module
abstract class FacadeModule {

    @Singleton
    @Binds
    abstract fun notesFacade(facade: NotesDbFacade): NotesFacade
}