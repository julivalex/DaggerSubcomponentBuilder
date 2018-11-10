package com.kotlin.note.daggersubcomponentbuilder.first.dagger;

import com.kotlin.note.daggersubcomponentbuilder.first.FirstActivity;

import dagger.Subcomponent;

@FirstActivityScope
@Subcomponent(modules = {FirstActivityModule.class})
public interface FirstActivityComponent {
    void inject(FirstActivity firstActivity);
}
