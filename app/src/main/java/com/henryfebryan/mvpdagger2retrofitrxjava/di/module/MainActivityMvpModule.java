package com.henryfebryan.mvpdagger2retrofitrxjava.di.module;

import com.henryfebryan.mvpdagger2retrofitrxjava.di.scopes.ActivityScope;
import com.henryfebryan.mvpdagger2retrofitrxjava.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }


}
