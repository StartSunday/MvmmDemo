package com.sun.common_login.mvvm.http

import com.fortunes.commonsdk.network.bean.BaseBean
import com.sun.common_login.mvvm.entity.LoginBean
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("user/register")
    fun register(@FieldMap map: Map<String, String>): Single<BaseBean<LoginBean>>

    @FormUrlEncoded
    @POST("user/login")
    fun login(@Field("username") index: String, @Field("password") map: String): Single<BaseBean<LoginBean>>
}