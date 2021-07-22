package com.example.mindboxsampleapp

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import cloud.mindbox.mobile_sdk.Mindbox

class MindboxReciever : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {

        // Handle action on push clicked, for example,
        val activityIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra(Mindbox.IS_OPENED_FROM_PUSH_BUNDLE_KEY, true)
            
        }
        context.startActivity(activityIntent)
    }

}