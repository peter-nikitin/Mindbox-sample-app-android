package com.example.mindboxsampleapp

import android.app.Application
import android.util.Log
import cloud.mindbox.mindbox_huawei.MindboxHuawei
import cloud.mindbox.mindbox_firebase.MindboxFirebase
import cloud.mindbox.mobile_sdk.Mindbox
import cloud.mindbox.mobile_sdk.MindboxConfiguration
import cloud.mindbox.mobile_sdk.logger.Level

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
        val configuration = MindboxConfiguration.Builder(
            applicationContext,
            "api.mindbox.ru",
            "mpush-test-android-sandbox-docs"
        )
            .subscribeCustomerIfCreated(true)
            .build()

        Mindbox.init(applicationContext, configuration, listOf(MindboxHuawei, MindboxFirebase))

        Mindbox.setLogLevel(Level.VERBOSE)

        Mindbox.subscribeDeviceUuid {
                deviceUUID -> Log.println(Log.INFO, "MindboxDeviceUUID", deviceUUID)
        }
        Mindbox.subscribePushToken {
                token ->
            if (token != null) {
                Log.println(Log.INFO, "MindboxToken", token)
            }
        }
    }
}

