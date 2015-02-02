package com.cat.external.app.update;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class UpdateService extends Service {
    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    class AppUpdateProxy implements AppUpdate {
        @Override
        public void setCustomDisplayer(Displayer displayer) {
            // TODO Auto-generated method stub
        }

        @Override
        public void downloadAndInstall(Version targetVersion) {
            // TODO Auto-generated method stub
        }

        @Override
        public void downloadAndInstallCurrent() {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkLatestVersion(String url, Parser parser, RequestVersion version) {
            // TODO Auto-generated method stub  
            
            
        }
    }
}
