package com.learning.androidlearning.movemarker.kotlin.splash

/**
 * Created by HP2 on 4/1/2018.
 */
interface BaseView<T> {
    fun setPresenter(presenter: T)
}