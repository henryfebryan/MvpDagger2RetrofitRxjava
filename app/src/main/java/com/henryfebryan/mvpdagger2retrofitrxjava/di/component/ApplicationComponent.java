package com.henryfebryan.mvpdagger2retrofitrxjava.di.component;

import android.content.Context;

import com.henryfebryan.mvpdagger2retrofitrxjava.MyApplication;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.ContextModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.RetrofitModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.qualifier.ApplicationContext;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.scopes.ApplicationScope;
import com.henryfebryan.mvpdagger2retrofitrxjava.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
