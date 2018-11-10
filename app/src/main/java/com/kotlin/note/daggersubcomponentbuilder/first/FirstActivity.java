package com.kotlin.note.daggersubcomponentbuilder.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kotlin.note.daggersubcomponentbuilder.R;
import com.kotlin.note.daggersubcomponentbuilder.app.App;
import com.kotlin.note.daggersubcomponentbuilder.second.SecondActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @Inject
    FirstActivityPresenter firstActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        ButterKnife.bind(this);

        App.getApp(this)
                .getComponentsHolder()
                .getFirstActivityComponent()
                .inject(this);
    }

    @OnClick(R.id.goToSecondActivity)
    void goToSecondActivityClick() {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            App.getApp(this)
                    .getComponentsHolder()
                    .releaseFirstActivityComponent();
        }
    }
}
