package com.henryfebryan.mvpdagger2retrofitrxjava.di.module;

import com.henryfebryan.mvpdagger2retrofitrxjava.MainActivity;
import com.henryfebryan.mvpdagger2retrofitrxjava.RecyclerViewAdapter;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}