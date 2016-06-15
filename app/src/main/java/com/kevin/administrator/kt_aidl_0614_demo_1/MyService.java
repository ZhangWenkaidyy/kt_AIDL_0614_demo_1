package com.kevin.administrator.kt_aidl_0614_demo_1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/6/14.
 */
public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    /**
     * 系统的底层会根据定义的.aidl文件生成一个接口名字和aidl文件名称一致
     * 内部有一个静态的抽象类为Stub
     * public interface xxxx{
     *    public static abstract Stub extends Binder  implments xxx{
     *        aidl文件中定义的函数
     *    }
     * }
     * 以内部类的形式具体的实现服务端提供给客户端的函数
     */
    public class MyBinder extends DataService.Stub {
        @Override
        public int getValue(String info) throws RemoteException {
            return 520;
        }

        @Override
        public String getstring(int num) throws RemoteException {
            return "dyy";
        }
    }

   /* public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    public int getValue(String info) {
        return 520;
    }

    public String getstring(int num) {
        return "dyy";
    }*/
}
