package com.example.helloworld.network

import com.example.helloworld.network.converter.JSONConverterFactory
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netModel = Kodein.Module {

    bind<OkHttpClient>() with singleton {
        val builder = OkHttpClient.Builder()
        builder.build()
    }

    bind<ApiClient>() with singleton {
        ApiClient(instance())
    }

    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .client(instance())
            // .addConverterFactory(JSONConverterFactory.create())
            // .addConverterFactory(GsonConverterFactory.create())
            //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://tcc.taobao.com/cc/json/")
            .build()

        // ?keyfrom=abc&key=2032414398&type=data&doctype=json&version=1.1&q=car/
    }
}