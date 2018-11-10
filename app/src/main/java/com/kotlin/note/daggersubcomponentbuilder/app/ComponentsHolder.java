package com.kotlin.note.daggersubcomponentbuilder.app;

import android.content.Context;
import android.os.Bundle;
import com.kotlin.note.daggersubcomponentbuilder.app.dagger.AppComponent;
import com.kotlin.note.daggersubcomponentbuilder.app.dagger.AppModule;
import com.kotlin.note.daggersubcomponentbuilder.app.dagger.DaggerAppComponent;
import com.kotlin.note.daggersubcomponentbuilder.first.dagger.FirstActivityComponent;
import com.kotlin.note.daggersubcomponentbuilder.second.dagger.SecondActivityComponent;
import com.kotlin.note.daggersubcomponentbuilder.second.dagger.SecondActivityModule;

public class ComponentsHolder {

    private final Context context;
    private AppComponent appComponent;
    private FirstActivityComponent firstActivityComponent;
    private SecondActivityComponent secondActivityComponent;

    ComponentsHolder(Context context) {
        this.context = context;
    }

    void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(context)).build();
    }

    private AppComponent getAppComponent() {
        return appComponent;
    }

    public FirstActivityComponent getFirstActivityComponent() {
        if (firstActivityComponent == null) {
            firstActivityComponent = getAppComponent().createFirstActivityComponent();
        }
        return firstActivityComponent;
    }

    public void releaseFirstActivityComponent() {
        firstActivityComponent = null;
    }

    public SecondActivityComponent getSecondActivityComponent(Bundle args) {
        if(secondActivityComponent == null) {
            secondActivityComponent = getAppComponent()
                    .createSecondActivityComponent(new SecondActivityModule(args));
        }
        return secondActivityComponent;
    }

    public void releaseSecondActivityComponent() {
        secondActivityComponent = null;
    }
}
