package com.kotlin.note.daggersubcomponentbuilder.second;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kotlin.note.daggersubcomponentbuilder.R;
import com.kotlin.note.daggersubcomponentbuilder.app.App;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_ARGS = "args";

    @Inject
    SecondActivityPresenter secondActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle args = getIntent().getBundleExtra(EXTRA_ARGS);
        App.getApp(this)
                .getComponentsHolder()
                .getSecondActivityComponent(args)
                .inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this)
                    .getComponentsHolder()
                    .releaseSecondActivityComponent();
        }
    }
}
