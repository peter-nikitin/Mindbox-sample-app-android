package com.example.mindboxsampleapp

import android.util.Log
import cloud.mindbox.mobile_sdk.Mindbox
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MindboxMessagingService:FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Метод возвращает boolen, чтобы можно было сделать фолбек для обработки пуш уведомлений
        val messageWasHandled = Mindbox.handleRemoteMessage(
            context = applicationContext,
            message = remoteMessage,
            channelId = "notification_channel_id", // Идентификатор канала для уведомлений, отправленных из Mindbox
            channelName = "notification_channel_name", // Название канала
            pushSmallIcon = R.mipmap.ic_launcher, // Маленька иконка для уведомлений
            channelDescription = "notification_channel_description" // Описание канала
        )


    }

    override fun onNewToken(token: String) {
        Mindbox.updateFmsToken(applicationContext, token)
    }
}