package com.henryfebryan.mvpdagger2retrofitrxjava.di.module;

import android.content.Context;

import com.henryfebryan.mvpdagger2retrofitrxjava.di.qualifier.ApplicationContext;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
