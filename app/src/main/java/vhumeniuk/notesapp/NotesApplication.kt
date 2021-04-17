package vhumeniuk.notesapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class NotesApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}