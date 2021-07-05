package com.zxy.zxyaidlservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by zsf on 2021/7/2 15:05
 * ******************************************
 * *    FaceInfo
 * ******************************************
 */
class FaceService : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        return iFaceService
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
    private var iFaceService = object : IFaceManager.Stub() {
        override fun getFaceInfo(): String  {
            return "我是数据"
        }

        override fun getUserinfo(): UserBean {
           return UserBean()
        }

    }

}