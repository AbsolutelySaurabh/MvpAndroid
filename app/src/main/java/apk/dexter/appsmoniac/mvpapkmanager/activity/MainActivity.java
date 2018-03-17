package apk.dexter.appsmoniac.mvpapkmanager.activity;

import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import apk.dexter.appsmoniac.mvpapkmanager.R;
import apk.dexter.appsmoniac.mvpapkmanager.adapter.AppAdapter;
import apk.dexter.appsmoniac.mvpapkmanager.core.GetAppsContract;
import apk.dexter.appsmoniac.mvpapkmanager.core.Presenter;

public class MainActivity extends AppCompatActivity implements GetAppsContract.View {

    private Presenter presenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter(this);
        presenter.getAppsFromManager(this);
        recyclerView = findViewById(R.id.recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetAppsSuccess(String message, List<ApplicationInfo> al_apps) {
        appAdapter = new AppAdapter(getApplicationContext(), al_apps);
        recyclerView.setAdapter(appAdapter);
    }

    @Override
    public void onGetFailure(String message) {
        Log.d("Status: ", message);
    }
}
