package com.example.helloworld.network

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import retrofit2.Retrofit

val netRepoModel = Kodein.Module {

    bind<NetRepo>() with provider {
        val retrofit = instance<Retrofit>()
        val netService: NetService = retrofit.create(NetService::class.java)
        NetRepo(netService)
    }
}