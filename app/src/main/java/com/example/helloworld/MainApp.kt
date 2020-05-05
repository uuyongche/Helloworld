package com.example.helloworld

import android.app.Application
import androidx.multidex.MultiDex
import com.example.helloworld.network.netModel
import com.example.helloworld.network.netRepoModel
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy
import com.squareup.leakcanary.LeakCanary

class MainApp : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        bind<Application>() with instance(this@MainApp)
        import(netModel)
        import(netRepoModel)
    }



    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }

        LeakCanary.install(this)
    }

}