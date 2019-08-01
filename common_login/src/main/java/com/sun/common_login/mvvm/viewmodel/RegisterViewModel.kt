package com.sun.common_login.mvvm.viewmodel

import com.fortunes.commonsdk.network.bean.BaseBean
import com.mou.basemvvm.base.BaseViewModel
import com.mou.basemvvm.helper.extens.async
import com.sun.common_login.mvvm.entity.LoginBean
import com.sun.common_login.mvvm.http.ApiService
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

class RegisterViewModel @Inject constructor(private val apiService: ApiService): BaseViewModel(){

    fun getRegister(username: String,password: String,repassword: String): Single<BaseBean<LoginBean>>{
        val map = HashMap<String,String>()
        map["username"] = username
        map["password"] = password
        map["repassword"] = repassword
        return  apiService.register(map)
            .async()
            .doOnSuccess {  }
            .doOnError {
                Timber.d("doOnError${it.message}")
            }
    }

}