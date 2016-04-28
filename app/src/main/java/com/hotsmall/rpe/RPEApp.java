package com.hotsmall.rpe;

import android.app.Application;

import com.hotsmall.rpe.client.APIClient;
import com.orhanobut.logger.Logger;

/**
 * Created by liqy on 16/1/23.
 */
public class RPEApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        APIClient.init(this);
        Logger.init("com.hotsmall.rpe")
                .hideThreadInfo()
                .methodOffset(3);
    }
}
