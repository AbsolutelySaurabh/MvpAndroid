package apk.dexter.appsmoniac.mvpapkmanager.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
public interface GetAppsContract {

    interface View{
        void onGetAppsSuccess(String message, List<ApplicationInfo> al_apps);
        void onGetFailure(String message);
    }

    interface Presenter{
        void getAppsFromManager(Context comtext);
    }
    interface Interactor {
        void initAsyncTaskCall(Context context);
    }
    interface onGetAppsListener{
        void onSuccess(String message, List<ApplicationInfo> al_apps);
        void onFailure(String message);
    }
}
