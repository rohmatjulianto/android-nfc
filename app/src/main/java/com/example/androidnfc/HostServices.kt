package com.example.androidnfc

import android.app.Service
import android.content.Intent
import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import android.util.Log
import com.example.androidnfc.MainActivity.Companion.hceServices


class HostServices : HostApduService() {

    lateinit var data: String

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        data = intent?.getStringExtra(hceServices).toString()
        return Service.START_STICKY
    }
    override fun processCommandApdu(commandApdu: ByteArray?, extras: Bundle?): ByteArray? {
        commandApdu?.let {apdu ->
            if (selectAidApdu(apdu)) {
                Log.d("yy", "processCommandApdu: selectApdu $data")
                return getWelcomeMessage()
            }
            else {
                Log.d("yy", "processCommandApdu: received $data")
                return data.toByteArray()
            }
        }
        return null
    }

    private fun getWelcomeMessage(): ByteArray? {
        return "Hello Desktop!".toByteArray()
    }


    private fun selectAidApdu(apdu: ByteArray): Boolean {
        return apdu.size >= 2 && apdu[0] == 0.toByte() && apdu[1] == 0xa4.toByte()
    }

    override fun onDeactivated(reason: Int) {
        Log.d("yy", "onDeactivated: $reason")
    }
}