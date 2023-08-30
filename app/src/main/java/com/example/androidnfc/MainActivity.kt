package com.example.androidnfc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, HostServices::class.java)
        intent.putExtra(hceServices, mandiri)
        startService(intent)

    }


    companion object {
        const val hceServices = "CARDHCE"
        const val mandiri =
            "hQVDUFYwMWFjTwegAAAGAiAgUAdRUklTQ1BNWgqTYAAIEgQQRpd/XyAKSEFTVE9OTyBCQV8tBGlkZW6fJQJpd2Mqn3QnMjAyMzA4MDExMDU3MDU3NTAxMzcwMDA0MTA0Njk3MTIzNDU2Nzg5"
        const val gopay =
            "hQVDUFYwMWFFTwegAAAGAiAgUAdRUklTQ1BNWgqTYAkUMAB3VgZfXy0EaWRlbmMen3QbY2hlcXVlOjI1MzE4OTM3NzY5NTc2NDQwNDY4"
        const val bsi =
            "hQVDUFYwMWFvTwegAAAGAiAgUAdRUklTQ1BNWgqTYARRcXREU4M/XyAPSEFTVE9OTyBCQVlVIFRSXy0EaWRlbl9QHW1haWx0bzpiYXl1Lmhhc3Rvbm9AZ21haWwuY29tnyUCODNjEZ90DiAjCAEQWAY0MhMRJVUQ"
    }
}