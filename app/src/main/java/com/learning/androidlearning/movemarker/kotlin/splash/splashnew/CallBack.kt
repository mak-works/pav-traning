package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

interface CallBack<T> {
    fun success(objects: T)
    fun responseFailure(objects: T)
    fun connectionFailure(errorThrowable: Throwable)
}