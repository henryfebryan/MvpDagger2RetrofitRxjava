package com.henryfebryan.mvpdagger2retrofitrxjava;

import android.app.Activity;
import android.app.Application;

import com.henryfebryan.mvpdagger2retrofitrxjava.di.component.ApplicationComponent;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.component.DaggerApplicationComponent;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.ContextModule;

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}