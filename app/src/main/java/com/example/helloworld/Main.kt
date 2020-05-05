package com.example.helloworld

import kotlin.properties.Delegates

class Main {

    var snam by Delegates.notNull<Int>()
    var ss: Int = 1

    fun main1() {
        Main12.NUM1.name
        Main12.NUM1.ordinal
        Main12.values()
    }

    fun main(args: Array<String>): Int {
        println("2222222")
        return 1
    }

    fun ArrayList<String>.aaa(a: Int, b: Int) {
        println("$a  $b")
        val empty2:Empty2<Int> = Empty2(1)
        val empty3:Empty2<Int> = Empty2<Int>(1)
        val empty4:Empty2<Int> = Empty2(1)
    }

}

const val SUCCESS_NAME = "SUCCESS_NAME"

open class Empty(val p: String) {
}

class Empty1(val p1: String): Empty(p1) {

    fun emp() {
        Main12.NUM1
    }
}

class Empty2<T>(t: T) {
    val value = t

    fun em(): Unit {

    }

    fun em1(): Int = 2
    fun em2() = 2
}

fun eee() {

}

enum class Main12(mValue: Int) {
    NUM1(123), NUM2(234), NUM3(345), NUM4(456)
}