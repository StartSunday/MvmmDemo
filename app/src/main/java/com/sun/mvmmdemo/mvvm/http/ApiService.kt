package com.sun.mvmmdemo.mvvm.http

import com.fortunes.commonsdk.network.bean.BaseBean
import com.sun.mvmmdemo.mvvm.entity.ArticleBean
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    /**
     * 判断是否上线
     */
    @GET("article/list/1/json")
    fun getArticle(): Single<BaseBean<ArticleBean>>
}