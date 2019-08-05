package com.sun.common_home.mvvm.viewmodel

import com.fortunes.commonsdk.network.bean.BaseBean
import com.mou.basemvvm.base.BaseViewModel
import com.mou.basemvvm.helper.extens.ObservableItemField
import com.mou.basemvvm.helper.extens.async
import com.sun.common_home.mvvm.entity.ArticleBean
import com.sun.common_home.mvvm.http.ApiService
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

/**
 * @作者 ${yongming}
 * @创建日期 2019/8/2 11:25
 * @说明
 */
class HomeViewModel
@Inject constructor(private val apiService: ApiService): BaseViewModel(){
    val chapterName = ObservableItemField<String>()
    val link = ObservableItemField<String>()
    fun  getArticle(): Single<BaseBean<ArticleBean>> {
        return apiService.getArticle()
            .async()
            .doOnSuccess {
                chapterName.set(it.data.datas[0].chapterName)
                link.set(it.data.datas[0].link)
            }.doOnError {
                Timber.d("doOnError")
            }

    }

}