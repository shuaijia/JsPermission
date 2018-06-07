# JsPermission

对安卓6.0及以上系统，运行时权限动态申请的封装库

## 用法

### step 1：添加依赖
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	dependencies {
	        compile 'com.github.shuaijia:JsPermission:v1.0'
	}
	
### step 2:在AndroidManiFest.xml中配置权限（为的是适配6.0以下系统）如：
```java
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.BODY_SENSORS"/>
```

### step 3：在Activity或者Fragment中
```java
if (JsPermissionUtils.needRequestPermission()) {
	JsPermission.with(this)
          .requestCode(20)
          .permission(Manifest.permission.CAMERA,
                      Manifest.permission.WRITE_EXTERNAL_STORAGE) // 不定长参数
          .callBack(this)
          .send();
}
或
if (JsPermissionUtils.needRequestPermission()) {
	JsPermission.with(this)
             .requestCode(30)
             .permission(Manifest.permission.BODY_SENSORS)
             .callBack(this)
             .send();
}
```
### step 4:callBack()方法中传入JsPermissionListener回调
```java
@Override
public void onPermit(int requestCode, String... permission) {
     Log.e(TAG, "onPermit: " + requestCode + " " + permission.toString());
}

@Override
public void onCancel(int requestCode, String... permission) {
     Log.e(TAG, "onCancel: " + requestCode + " " + permission.toString());
}
```
### step 5:在Activity中加入
```java
@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
     JsPermission.onRequestPermissionResult(requestCode, permissions, grantResults);
}
```
### step 6:好了，可以随心所欲了！
更多精彩内容，请关注我的微信公众号——Android机动车

![这里写图片描述](http://img.blog.csdn.net/20180110155733884?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvamlhc2h1YWk5NA==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)	
