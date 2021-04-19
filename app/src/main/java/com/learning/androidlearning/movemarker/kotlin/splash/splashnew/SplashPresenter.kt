package com.learning.androidlearning.movemarker.kotlin.splash.splashnew

class SplashPresenter(view: SplashContract.SplashView,model:SplashModel) :SplashContract.SplashPresenter  {

    private var model: SplashModel? = null
    private var view: SplashContract.SplashView? = null

    init {
        this.view=view;
        this.model=model
    }
    override fun requestData() {
      model?.getUserData(object:CallBack<List<UserData>>
      {
          override fun success(objects: List<UserData>) {
              view?.showData(objects)
          }

          override fun responseFailure(objects: List<UserData>) {}

          override fun connectionFailure(errorThrowable: Throwable?) {
              view?.showfailure(errorThrowable!!)
          }
      });
    }
}