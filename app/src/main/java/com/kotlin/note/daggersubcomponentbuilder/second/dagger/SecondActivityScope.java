package com.kotlin.note.daggersubcomponentbuilder.second.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface SecondActivityScope {
}
