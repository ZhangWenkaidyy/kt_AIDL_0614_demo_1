package com.kevin.administrator.xinshi_demo_1;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;



/**
 * Created by Administrator on 2016/6/14.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
   public Handler serverHandler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
       }
   };
Messenger serverMessenger=new Messenger(serverHandler);


}
