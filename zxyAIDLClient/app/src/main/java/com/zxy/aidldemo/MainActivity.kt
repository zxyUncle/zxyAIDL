package com.zxy.aidldemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zxy.aidldemo.face.FaceManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

/**
 * Created by zsf on 2021/7/5 11:25
 * ******************************************
 * * 
 * ******************************************
 */
class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnConnect.setOnClickListener {
            tvInfo.text = "${FaceManager.service.aidl()?.faceInfo ?: "null"}${Random.nextInt(10)}"
        }

        btnBean.setOnClickListener {
            tvBean.text = "${FaceManager.service.aidl()?.userinfo}${Random.nextInt(10)}"
        }

    }

    override fun onResume() {
        super.onResume()
        FaceManager.connect(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        FaceManager.unConnect(this)
    }
}