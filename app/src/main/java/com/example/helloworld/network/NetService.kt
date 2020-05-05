package com.example.helloworld.network

import com.example.helloworld.network.netResponse.NetData
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetService {

    @GET("api.php")
    fun querySome(@Query("key")a: String = "free", @Query("appid")b: String = "0", @Query("msg")c: String = "关键字"): Observable<NetData>
}