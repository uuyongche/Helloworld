package com.example.helloworld


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.solver.widgets.Rectangle
import com.example.helloworld.event.Main1Event
import com.hwangjr.rxbus.RxBus
import com.hwangjr.rxbus.annotation.Subscribe
import java.io.File
import java.lang.Exception
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_main)
        RxBus.get().register(this)

        val name: String
        val name1: String ?= null
        val m: Math
        Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
        // TODO 这里需要做一些测试代码
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.get().unregister(this)
    }

    fun main(args: Array<String>) {
        println("Helloworld")
    }

    fun main1(obj: Any) {
        if (obj is MainActivity) {

        }
    }

    fun main2(a:Int, b: Int): Int {
        return a + b
    }

    fun main3(a: Int, b: Int) = a + b

    fun main4(a: Int, b: Int): Unit {
        println("$a  $b")
        println("$a $b")

        val a: Int = 3
        val b = 3
        val c = 3
        var x: Int = 5
        x = x + 1
        x += 1
        val e = 4
        var f = 5
//
        /**/
        val g = 4
    }

    fun main5() {
        var a = 1
        val s1 = "a is $a"
        a = 2
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        if (s1 != null) {

        }
    }

    fun main6(s1: String?) = s1?.length

    fun main7(a: Int, b: Int) = if (a > b) a else b

    fun main8() {
        val str = listOf<String>("a", "b", "c")
        for (s in str) {
            println(s)
        }
        str.forEach { it -> println(it)}
    }

    fun main9(obj: Any) {
        when (obj) {
            "a" -> println("aaaaaaaa")
            1 -> print("11111111")
        }
    }

    fun main10() {
        val x = 1
        val y = 19
        if (x in 0..y){
            println("sdfsdfsdfsdf")
        }

        if (x !in 0..y) {
            println("werwerwer")
        }

        for (x in 0..y) {
            println("for index count")
        }

        val s = Rectangle()
    }

    fun main11() {
        println("main11")

    }

    fun main12(a: Int = 0, b: Int) {
        val mList = ArrayList<String>()
        val position = mList.filter { it.isNotEmpty() }
        if ("" in mList) {

        }

        println("name: ${mList.size}")

        println("name1: ${mList.size}")
    }

    fun main13() {
        val files = File("").listFiles()
        println(files.size)
        val s: String ?= ""
        s?.let {
            it -> s.length
        }

        try {

        } catch (e: Exception) {
            println(e.message)
        }

        with(s) {
            this?.length
        }

        val result = kotlin.run {
            1000
        }

        val result1: String? = s.apply {  }.also { it.plus("b") }

    }

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    @Subscribe
    fun onEvent(main1Event: Main1Event) {
        println("#### main1Event: ${main1Event.index}")
    }
}

val list = ArrayList<String>()
val a = list.filter {
        it -> println(it)
        return@filter true
}

object Strings {
    val name: String = "LiuChao"
}

object Person {
    val name: String = "name"
}

class Main6(val a: String, val b: String) {

}

class Main5(a: String, b: String): Main1(a, b) {

}

fun parseInt(str: String): Int? {
    return str.toInt()
}

open class Main1(val a:String, val b: String)
data class Main2(val c:Int, val d: Int)
data class Main4(val a: String, val b: String)
data class Main3(val c: Double, val d: Double) {
    fun main(a: Int): Int {
        return a
    }


}
