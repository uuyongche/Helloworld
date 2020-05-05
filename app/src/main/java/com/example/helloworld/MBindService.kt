package com.example.helloworld

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MBindService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    class MBinder: Binder() {

    }
}
