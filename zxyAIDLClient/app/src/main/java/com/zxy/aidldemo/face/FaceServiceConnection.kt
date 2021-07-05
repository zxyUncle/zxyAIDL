package com.zxy.aidldemo.face

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import com.zxy.zxyaidlservice.IFaceManager

/**
 * Created by zsf on 2021/7/2 15:31
 * ******************************************
 * *
 * ******************************************
 */
class FaceServiceConnection : ServiceConnection {
    var iFaceManager: IFaceManager? = null

    fun aidl(): IFaceManager? {
        return iFaceManager
    }

    override fun onServiceConnected(componentName: ComponentName?, iBinder: IBinder?) {
        iFaceManager = IFaceManager.Stub.asInterface(iBinder)
        Log.e(FaceManager.TAG, "连接成功:")
    }

    override fun onServiceDisconnected(componentName: ComponentName?) {
        iFaceManager = null
        Log.e(FaceManager.TAG, "断开连接")
    }
}