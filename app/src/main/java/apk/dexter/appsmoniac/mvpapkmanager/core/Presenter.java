package apk.dexter.appsmoniac.mvpapkmanager.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import java.util.List;

/**
 * Created by absolutelysaurabh on 17/3/18.
 */

public class Presenter implements GetAppsContract.Presenter, GetAppsContract.onGetAppsListener{

    private GetAppsInteractor interactor;
    private GetAppsContract.View mGetAppsView;

    public Presenter(GetAppsContract.View mGetAppsView){
        this.mGetAppsView = mGetAppsView;
        interactor = new GetAppsInteractor(this);
    }

    @Override
    public void getAppsFromManager(Context comtext) {
        interactor.initAsyncTaskCall(comtext);
    }

    @Override
    public void onSuccess(String message, List<ApplicationInfo> al_apps) {
        mGetAppsView.onGetAppsSuccess(message, al_apps);
    }

    @Override
    public void onFailure(String message) {
        mGetAppsView.onGetFailure(message);
    }
}
