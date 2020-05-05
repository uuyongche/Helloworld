package com.example.helloworld.network

import com.example.helloworld.network.netResponse.NetData
import io.reactivex.rxjava3.core.Observable

class NetRepo(private val netService: NetService): NetService by netService {

//    fun query(a: String, b: String): Observable<NetData> {
//        return netService.querySome(a, b)
//    }

}