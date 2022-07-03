package me.lucky.usbkill

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat

class RestartReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action != Intent.ACTION_BOOT_COMPLETED &&
            intent?.action != Intent.ACTION_MY_PACKAGE_REPLACED) return
        if (!Preferences(context ?: return).isEnabled) return
        ContextCompat.startForegroundService(
            context.applicationContext,
            Intent(context.applicationContext, ForegroundService::class.java),
        )
    }
}