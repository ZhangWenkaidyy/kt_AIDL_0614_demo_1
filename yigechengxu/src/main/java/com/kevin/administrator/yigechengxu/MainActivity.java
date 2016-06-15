package com.kevin.administrator.yigechengxu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kevin.administrator.kt_aidl_0614_demo_1.DataService;

public class MainActivity extends AppCompatActivity {
    private DataService dataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //获取aidl文件--的底层接口的对象
            dataService = DataService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void bangding(View view) {
        Intent intent = new Intent();
        intent.setAction("com.kevin.action");
        intent.setPackage("com.kevin.administrator.kt_aidl_0614_demo_1");
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
        Log.i("tag", "-绑定状态---");
    }

    public void tongbu(View view) {
        try {
            int num = dataService.getValue("zwk");
            String str = dataService.getstring(0);
            Log.i("tag", "获取另一个程序服务传的值-num" + num + "str" + str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
