package com.example.helloworld

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.*
import java.io.IOException

class Main3Activity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        runOnUiThread(object : Runnable {
            override fun run() {

            }

        })

        window.decorView.post {

        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main3Activity", "onPause......")
        testNetwork()
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    fun testNetwork() {
        val url = "https://www.baidu.com"
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        okHttpClient.newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.i("Main3Activity", "onFailure......")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.i("Main3Activity", "onResponse......")
                    val result = response.body()?.string()
                    Log.i("Main3Activity", result)

                }

            })

        Glide.with(this)
            .load("https://profile.csdnimg.cn/4/A/7/3_qq_23547831")
            .into(findViewById(R.id.imageView))



//        Observable.create<String> { subscribe ->
//            okHttpClient.newCall(request)
//                .enqueue(object : Callback {
//                    override fun onFailure(call: Call, e: IOException) {
//                        Log.i("Main3Activity", "onFailure......")
//                    }
//
//                    override fun onResponse(call: Call, response: Response) {
//                        Log.i("Main3Activity", "onResponse......")
//                        val result = response.body()?.string()
//                        Log.i("Main3Activity", result)
//
//                    }
//
//                })
//        }.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe { it ->
//                Log.i("Main3Activity", "network result is:$it")
//            }
    }
}