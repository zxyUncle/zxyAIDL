// IAIDLManager.aidl
package com.zxy.zxyaidlservice;
import com.zxy.zxyaidlservice.UserBean;
// Declare any non-default types here with import statements


interface IFaceManager {
    String getFaceInfo();
    UserBean getUserinfo();
}