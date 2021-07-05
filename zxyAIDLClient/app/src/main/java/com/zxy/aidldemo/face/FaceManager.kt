package com.zxy.aidldemo.face

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import com.zxy.zxyaidlservice.IFaceManager

/**
 * Created by zsf on 2021/7/5 11:24
 * ******************************************
 * *face    工具类
 * ******************************************
 */
object FaceManager {
    const val TAG="face"
    private const val ACTION_CONNECT = "action.zxy.faceService"
    private const val SERVICE_PACKAGE = "com.zxy.zxyaidlservice"

    @JvmStatic
    val service by lazy {
        FaceServiceConnection()
    }

    @JvmStatic
    fun connect(activity: Activity) {
        if(!appInstalledOrNot(activity)) {
            Toast.makeText(activity,"请安装AIDL服务端",Toast.LENGTH_SHORT).show()
            return
        }
        if (service.iFaceManager == null) {
            var intent = Intent(IFaceManager::class.java.name)
            intent.action = ACTION_CONNECT
            intent.setPackage(SERVICE_PACKAGE)
            activity.bindService(intent, service, Context.BIND_AUTO_CREATE)
        }
    }

    @JvmStatic
    fun unConnect(activity: Activity){
        activity.unbindService(service)
    }


    private fun appInstalledOrNot( activity: Activity): Boolean {
        val pm = activity.packageManager
        val isInstall: Boolean = try {
            pm.getPackageInfo(SERVICE_PACKAGE, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return isInstall
    }
}