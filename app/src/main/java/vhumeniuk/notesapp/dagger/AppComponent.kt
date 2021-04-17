package vhumeniuk.notesapp;


import android.app.Application
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.android.AndroidInjector;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule
import vhumeniuk.notesapp.dagger.module.AppModule

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent: AndroidInjector<NotesApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
