package com.example.helloworld

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworld.event.Main1Event
import com.hwangjr.rxbus.RxBus
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.toObservable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.io.File


class Main2Activity: AppCompatActivity() {

    private val TAG: String = "Main2Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxBus.get().register(this)
//        test1()
//        test2()
//        test4()
        window.decorView.invalidate()
        Log.i(TAG, "onCreate......")
        test7()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart......")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart......")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume......")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause......")
        RxBus.get().post(Main1Event(1))
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop......")
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy......")
        super.onDestroy()
        RxBus.get().unregister(this)
    }

    fun test1() {
        val list = listOf<Any>("a", 1, "b", 2, "c", 3)
        list.toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                println(it)
            }
    }

    fun test2() {
        Observable.create<Int> { subscribe ->
            subscribe.onNext(1)
            subscribe.onComplete()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Int> {
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable?) {
                    println("onSubscribe")
                }

                override fun onNext(t: Int?) {
                    println("onNext $t")
                }

                override fun onError(e: Throwable?) {
                    println("onError")
                }

            })
    }

//    fun test3() {
//        val list = listOf<Int>(1, 2, ,3 ,4)
//        Observable.fromIterable(list)
//        list.toObservable()
//        Observable.just("", "", "", 4)
//    }

    fun test4() {
        val file: File = File("")
        Observable.create<File> { subscribe ->
            subscribe.onNext(file)
            subscribe.onComplete()
        }.flatMap { file ->
            file.listFiles().toObservable()
        }.filter {
            file.name.startsWith("a")
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { file ->
                println(file.name)
            }
    }
    
    fun test5() {
        val observer = object: Observer<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: String?) {
            }

            override fun onError(e: Throwable?) {
            }

        }

        val subscriber = object : Subscriber<String> {
            override fun onComplete() {
            }

            override fun onSubscribe(s: Subscription?) {
            }

            override fun onNext(t: String?) {
            }

            override fun onError(t: Throwable?) {
            }
        }
    }

    fun test6() {
        Observable.create<String> { subscribe->

        }

        Observable.create<String>(object : ObservableOnSubscribe<String> {
            override fun subscribe(emitter: ObservableEmitter<String>?) {
                emitter?.onNext("123")
                emitter?.onNext("345")
                emitter?.onNext("567")
                emitter?.onComplete()
            }

        })

        Observable.just(1, 2, 3)
            .subscribe { it ->
                println("it is $it")
            }
    }

    fun test7() {
        val names = arrayOf("LiuChao", "Wangyamin", "LiuXiaoChao")
        Observable.fromArray(names)
            .map {
                println("first map name is $it")
                it + "   aaa"
            }.doOnNext {}
            .doAfterNext {}
            .doOnEach {

            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it ->
                println("second name it is $it")
                it + "   bbb"
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { it ->
                println("name is $it")
            }

    }

    fun test8() {
        PublishSubject.create<Int>()
        Flowable.just("1", "2")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun test9() {
        val a = arrayOf("")
        val b:List<String> = listOf("")
        val c:Set<String> = setOf("")
        val d: Map<String, String> = mapOf()
        b.toList()
        c.toSet()
        d.toMap()
    }
}