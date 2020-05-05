package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.network.NetRepo
import com.example.helloworld.network.NetService
import com.example.helloworld.network.converter.JSONConverterFactory
import com.example.helloworld.network.netResponse.NetData
import com.example.libtest.MainJava
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.android.appKodein
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.github.salomonbrys.kodein.instance as instance

class Main4Activity : AppCompatActivity(), KodeinInjected {

    override val injector = KodeinInjector()
    private val netRepo: NetRepo by instance()
    private val TAG: String = "Main4Activity"
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(appKodein())
        setContentView(R.layout.activity_main4)
        window.decorView.post {

        }

        MainJava()
        Object().wait()
        Log.i(TAG, "onCreate......")
        button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
//            netRepo.query("18614030612", "b")
//                .subscribe { it ->
//                    Log.i(TAG, "query: $it")
//                }
            val retrofit = Retrofit.Builder()
                .addConverterFactory(JSONConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.qingyunke.com/")
                .build()
            retrofit.create(NetService::class.java).querySome()
                .subscribe { it ->
                    Log.i(TAG, "onResponse...... ${Gson().toJson(it)}")
                }
//            retrofit.create(NetService::class.java).querySome().enqueue(object : Observable<NetData> {
//                override fun onFailure(call: Call<NetData>, t: Throwable) {
//                    Log.i(TAG, "onFailure.... ${t.message}")
//                }
//
//                override fun onResponse(call: Call<NetData>, response: Response<NetData>) {
//
//                    Log.i(TAG, "onResponse...... ${Gson().toJson(response.body())}")
//                }
//
//            })
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause......")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}