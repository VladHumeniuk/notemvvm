package vhumeniuk.notesapp.dagger.module

import dagger.Binds
import dagger.Module
import vhumeniuk.notesapp.facade.NotesFacade
import vhumeniuk.notesapp.facade.NotesMockFacade
import javax.inject.Singleton

@Module
abstract class FacadeModule {

    @Singleton
    @Binds
    abstract fun notesFacade(facade: NotesMockFacade): NotesFacade
}