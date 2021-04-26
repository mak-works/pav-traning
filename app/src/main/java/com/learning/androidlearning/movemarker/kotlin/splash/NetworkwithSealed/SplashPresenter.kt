package com.learning.androidlearning.movemarker.kotlin.splash.NetworkwithSealed

import com.learning.androidlearning.movemarker.kotlin.splash.splashnew.CallBack
import com.learning.androidlearning.movemarker.kotlin.splash.splashnew.ServiceBuilder
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SplashPresenter(private var view: SplashContract.SplashView,private var splashModel: SplashContract.SplashModel):SplashContract.SplashPresenter {

    override fun requestData() {
        fun getData(callBack: UserResponse<List<UserData>>) {
            when (callBack) {
                is UserResponse.Success -> view.showData(callBack.data)
                is UserResponse.ResponseFailure -> callBack.data?.let { view.showResponseFailure(it) }
                is UserResponse.ConnectionFailure -> callBack.error?.let { view.showConnectionFailure(it) }
            }
        }
       /* splashModel.getUserData(callBack: Result<List<UserData>>)
        {

        }*/
    }
}


