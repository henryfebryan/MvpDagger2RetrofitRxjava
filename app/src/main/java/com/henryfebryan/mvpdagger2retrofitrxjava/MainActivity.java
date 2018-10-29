package com.henryfebryan.mvpdagger2retrofitrxjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.henryfebryan.mvpdagger2retrofitrxjava.di.component.ApplicationComponent;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.component.DaggerMainActivityComponent;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.component.MainActivityComponent;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.MainActivityContextModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.module.MainActivityMvpModule;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.qualifier.ActivityContext;
import com.henryfebryan.mvpdagger2retrofitrxjava.di.qualifier.ApplicationContext;
import com.henryfebryan.mvpdagger2retrofitrxjava.mvp.MainActivityContract;
import com.henryfebryan.mvpdagger2retrofitrxjava.mvp.PresenterImpl;
import com.henryfebryan.mvpdagger2retrofitrxjava.pojo.CryptoData;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();
    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
    }

    @Override
    public void showData(List<CryptoData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}