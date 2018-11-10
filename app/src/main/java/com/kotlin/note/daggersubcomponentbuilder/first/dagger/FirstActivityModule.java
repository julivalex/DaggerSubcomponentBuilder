package com.kotlin.note.daggersubcomponentbuilder.first.dagger;

import com.kotlin.note.daggersubcomponentbuilder.first.FirstActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FirstActivityModule {

    @FirstActivityScope
    @Provides
    FirstActivityPresenter prodideFirstActivityPresenter() {
        return new FirstActivityPresenter();
    }
}
