package com.kotlin.note.daggersubcomponentbuilder.app;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    ComponentsHolder componentsHolder;

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        componentsHolder = new ComponentsHolder(this);
        componentsHolder.init();
    }

    public ComponentsHolder getComponentsHolder() {
        return componentsHolder;
    }
}
