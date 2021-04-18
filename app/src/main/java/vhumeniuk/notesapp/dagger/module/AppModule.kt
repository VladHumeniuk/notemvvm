package vhumeniuk.notesapp.dagger.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vhumeniuk.notesapp.MainActivity
import vhumeniuk.notesapp.presentation.addnote.AddNoteFragment
import vhumeniuk.notesapp.presentation.noteslist.NotesFragment

@Module(includes = [
    GlobalModule::class,
    ViewModelModule::class,
    FacadeModule::class
])
abstract class AppModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun notesListFragment(): NotesFragment

    @ContributesAndroidInjector
    abstract fun addNoteFragment(): AddNoteFragment
}