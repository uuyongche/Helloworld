package com.example.helloworld.view

import android.content.Context
import android.graphics.Canvas
import android.os.Parcelable
import android.util.AttributeSet
import android.util.Log
import android.view.View

class M1View : View {

    val TAG: String = "M1View"

    constructor(context: Context?) : super(context) {
    }

    constructor(context: Context?, attrs: AttributeSet?): super(context, attrs)

    override fun onAttachedToWindow() {
        Log.i(TAG, "onAttachedToWindow...")
        super.onAttachedToWindow()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.i(TAG, "onMeasure...")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        Log.i(TAG, "onLayout...")
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        Log.i(TAG, "onDraw...")
        super.onDraw(canvas)
    }

    override fun onDetachedFromWindow() {
        Log.i(TAG, "onDetachedFromWindow...")
        super.onDetachedFromWindow()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        Log.i(TAG, "onFinishInflate...")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        Log.i(TAG, "onSizeChanged...")
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()
        Log.i(TAG, "onSaveInstanceState...")
    }

    override fun onWindowFocusChanged(hasWindowFocus: Boolean) {
        super.onWindowFocusChanged(hasWindowFocus)
        Log.i(TAG, "onWindowFocusChanged...")
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        super.onRestoreInstanceState(state)
        Log.i(TAG, "onRestoreInstanceState...")
    }
}