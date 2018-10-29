package com.henryfebryan.mvpdagger2retrofitrxjava.di.component;

import android.content.Context;

import com.henryfebryan.mvpdagger2retrofitrxjava.MainActivity;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.AdapterModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.MainActivityMvpModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.qualifier.ActivityContext;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}

