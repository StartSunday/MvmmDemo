package com.sun.common_mine.mvvm.http

import com.fortunes.commonsdk.network.bean.BaseBean
import com.sun.common_mine.mvvm.entity.MineBean
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("project/list/{pageNum}/json")
    fun getProjectList(@Path("pageNum") pageNum: Int, @Query("cid") cid: Int): Single<BaseBean<MineBean>>
}