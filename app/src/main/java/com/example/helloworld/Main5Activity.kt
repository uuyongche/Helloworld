package com.example.helloworld

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.view.M1View
import java.lang.ref.SoftReference

class Main5Activity: AppCompatActivity() {

    val TAG: String = "M1View"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        Log.i(TAG, "onCreate...")

        classLoader

        findViewById<M1View>(R.id.m1View).setOnClickListener {
            Log.i(TAG, "1111111111111111")
            Log.i(TAG, "2222222222222222")
            Log.i(TAG, "33333333333333333")

            arrayOf("")
            intArrayOf(1,2)
            floatArrayOf(1f)
            doubleArrayOf(2.0)
            listOf<String>("")
            val a = arrayListOf<String>("")

        }

        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, createM1Fragment(), "m1Fragment")
            .commit()
    }

    override fun onRestart() {
        super.onRestart()
        val a:SoftReference<String> = SoftReference<String>("")
        Log.i(TAG, "onRestart...")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart...")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume...")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause...")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop...")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy...")

    }

}