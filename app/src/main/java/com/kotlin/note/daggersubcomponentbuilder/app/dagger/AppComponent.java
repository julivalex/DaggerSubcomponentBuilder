package com.kotlin.note.daggersubcomponentbuilder.app.dagger;

import com.kotlin.note.daggersubcomponentbuilder.first.dagger.FirstActivityComponent;
import com.kotlin.note.daggersubcomponentbuilder.second.dagger.SecondActivityComponent;
import com.kotlin.note.daggersubcomponentbuilder.second.dagger.SecondActivityModule;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {
    FirstActivityComponent createFirstActivityComponent();
    SecondActivityComponent createSecondActivityComponent(SecondActivityModule secondActivityModule);
}
