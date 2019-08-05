package com.sun.common_home.mvvm.http

import com.fortunes.commonsdk.network.bean.BaseBean
import com.sun.common_home.mvvm.entity.ArticleBean
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
//    @FormUrlEncoded
//    @POST("user/register")
//    fun register(@FieldMap map: Map<String, String>): Single<BaseBean<LoginBean>>
//
//    @FormUrlEncoded
//    @POST("user/login")
//    fun login(@Field("username") index: String, @Field("password") map: String): Single<BaseBean<LoginBean>>

    /**
     * 判断是否上线
     */
    @GET("article/list/1/json")
    fun getArticle(): Single<BaseBean<ArticleBean>>
}