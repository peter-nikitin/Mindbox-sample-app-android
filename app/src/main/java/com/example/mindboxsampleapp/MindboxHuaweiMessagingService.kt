package com.example.mindboxsampleapp

import android.util.Log
import cloud.mindbox.mobile_sdk.Mindbox

import com.huawei.hms.push.*

class MindboxHuaweiMessagingService: HmsMessageService() {
    override fun onNewToken(token: String) {
        Mindbox.updatePushToken(applicationContext, token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        // Активти поумолчанию. Откроется, если пришла ссылка, которой нет в перечислении
        val defaultActivity = MainActivity::class.java

        // Перечесление ссылок и активити, которые должны открываться по разным ссылкам
        val activities = mapOf(
            "https://mindbox.ru/" to defaultActivity,
        )

        Log.i("Income Message", remoteMessage.toString())

        // Метод возвращает boolen, чтобы можно было сделать фолбек для обработки пуш уведомлений
        val messageWasHandled = Mindbox.handleRemoteMessage(
            context = applicationContext,
            message = remoteMessage,
            activities = activities,
            channelId = "notification_channel_id", // Идентификатор канала для уведомлений, отправленных из Mindbox
            channelName = "notification_channel_name", // Название канала
            pushSmallIcon = R.mipmap.ic_launcher, // Маленька иконка для уведомлений
            defaultActivity = defaultActivity,
            channelDescription = "notification_channel_description" // Описание канала
        )
    }
}