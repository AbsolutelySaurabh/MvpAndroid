package apk.dexter.appsmoniac.mvpapkmanager.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.GetChars;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class GetAppsInteractor implements GetAppsContract.Interactor {

    private GetAppsContract.onGetAppsListener onGetAppsListener;
    private PackageManager packageManager = null;
    List<ApplicationInfo> al_apps = new ArrayList<>();

    public GetAppsInteractor(GetAppsContract.onGetAppsListener onGetAppsListener){
        this.onGetAppsListener = onGetAppsListener;
    }

    @Override
    public void initAsyncTaskCall(Context context) {
        packageManager = context.getPackageManager();
//        al_apps = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
//        Log.e("al_apps: " , al_apps.toString());
        new LoadApplications().execute();
    }

    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list) {
        ArrayList<ApplicationInfo> applist = new ArrayList<ApplicationInfo>();
        for (ApplicationInfo info : list) {
            try {
                if (null != packageManager.getLaunchIntentForPackage(info.packageName)) {
                    applist.add(info);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return applist;
    }


    private class LoadApplications extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            al_apps = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));

            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            onGetAppsListener.onSuccess("List Size: " + al_apps.size(), al_apps);
            Log.e("al_apps: " , al_apps.toString());
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
