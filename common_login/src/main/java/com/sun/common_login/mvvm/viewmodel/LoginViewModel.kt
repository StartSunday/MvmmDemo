package com.sun.common_login.mvvm.viewmodel

import com.fortunes.commonsdk.network.bean.BaseBean
import com.mou.basemvvm.base.BaseViewModel
import com.mou.basemvvm.helper.extens.async
import com.sun.common_login.mvvm.entity.LoginBean
import com.sun.common_login.mvvm.http.ApiService
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val apiService: ApiService): BaseViewModel(){

    fun getLogin(username: String,password: String): Single<BaseBean<LoginBean>>{
        return  apiService.login(username,password)
            .async()
            .doOnSuccess {  }
            .doOnError {
                Timber.d("doOnError${it.message}")
            }
    }

}