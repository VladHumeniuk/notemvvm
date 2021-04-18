package vhumeniuk.notesapp.dagger.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vhumeniuk.notesapp.dagger.scope.ViewModelKey
import vhumeniuk.notesapp.viewmodel.AddNoteViewModel
import vhumeniuk.notesapp.viewmodel.NotesListViewModel
import vhumeniuk.notesapp.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotesListViewModel::class)
    abstract fun notesLiseViewModel(viewModel: NotesListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddNoteViewModel::class)
    abstract fun addNoteViewModel(vieWModel: AddNoteViewModel): ViewModel

    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}