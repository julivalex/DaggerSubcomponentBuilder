package com.kotlin.note.daggersubcomponentbuilder.second.dagger;

import com.kotlin.note.daggersubcomponentbuilder.second.SecondActivity;

import dagger.Subcomponent;

@SecondActivityScope
@Subcomponent(modules = {SecondActivityModule.class})
public interface SecondActivityComponent {
    void inject(SecondActivity secondActivity);
}
