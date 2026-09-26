package com.zaneschepke.wireguardautotunnel.service

import android.content.Context
import android.content.Intent
import android.net.VpnService
import androidx.core.content.ContextCompat
import com.zaneschepke.wireguardautotunnel.service.autotunnel.AutoTunnelService
import com.zaneschepke.wireguardautotunnel.util.permission.NotificationPermissionHelper

class ServiceManager(private val context: Context) {

    fun startAutoTunnelService() {
        ContextCompat.startForegroundService(context, Intent(context, AutoTunnelService::class.java))
    }

    fun stopAutoTunnelService() {
        context.stopService(Intent(context, AutoTunnelService::class.java))
    }

    fun hasVpnPermission(): Boolean {
        return VpnService.prepare(context) == null
    }

    fun hasNotificationPermission(): Boolean {
        return NotificationPermissionHelper.isPermissionGranted(context)
    }
}
