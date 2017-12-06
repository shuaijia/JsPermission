package com.jia.permissiondemo;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jia.jspermission.listener.JsPermissionListener;
import com.jia.jspermission.utils.JsPermission;
import com.jia.jspermission.utils.JsPermissionUtils;

public class MainActivity extends AppCompatActivity implements JsPermissionListener {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (JsPermissionUtils.needRequestPermission()) {
            JsPermission.with(this)
                    .requestCode(20)
                    .permission(Manifest.permission.CAMERA)
                    .callBack(this)
                    .send();
        }

//        if (JsPermissionUtils.needRequestPermission()) {
//            JsPermission.with(this)
//                    .requestCode(30)
//                    .permission(Manifest.permission.BODY_SENSORS)
//                    .callBack(this)
//                    .send();
//        }
    }

    @Override
    public void onPermit(int requestCode, String... permission) {
        Log.e(TAG, "onPermit: " + requestCode + " " + permission.toString());
    }

    @Override
    public void onCancel(int requestCode, String... permission) {
        Log.e(TAG, "onCancel: " + requestCode + " " + permission.toString());
        JsPermissionUtils.getAppDetailSettingIntent(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        JsPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
    }
}
