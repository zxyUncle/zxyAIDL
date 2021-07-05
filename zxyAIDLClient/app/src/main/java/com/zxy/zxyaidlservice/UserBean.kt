package com.zxy.zxyaidlservice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by zsf on 2021/7/5 11:40
 * ******************************************
 * *
 * ******************************************
 */
@Parcelize
data class UserBean(
        var uName: String = "张三",
        var uAge: String = "18",
        var uSex: String = "人妖"
) : Parcelable