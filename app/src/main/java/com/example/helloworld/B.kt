package com.example.helloworld

import kotlin.properties.Delegates

const val a11 = 1

class B {
    val a22 get() = 123

    var a33: Int = 0
        get() = 12
    set(value) {
        field = value
    }

    val isEmpty get() = a22 == 0

    val a44: Int by lazy {
        3
    }
}