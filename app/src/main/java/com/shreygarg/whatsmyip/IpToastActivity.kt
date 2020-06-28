package com.shreygarg.whatsmyip

import android.net.wifi.WifiManager
import android.os.Bundle
import android.text.format.Formatter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IpToastActivity : AppCompatActivity() {
    companion object {
        const val NOT_CONNECTED = "0.0.0.0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showIpToast()
        finish()
    }

    @Suppress("DEPRECATION")
    private fun showIpToast() {
        val wm = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        val ip: String = Formatter.formatIpAddress(wm.connectionInfo.ipAddress)
        if (ip != NOT_CONNECTED)
            Toast.makeText(this, ip, Toast.LENGTH_LONG).show()
        else Toast.makeText(this, getString(R.string.not_connected), Toast.LENGTH_LONG).show()
    }
}