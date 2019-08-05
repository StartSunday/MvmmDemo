package com.sun.common_my.mvvm.viewmodel

import com.mou.basemvvm.base.BaseViewModel
import com.sun.common_my.mvvm.http.ApiService
import javax.inject.Inject

/**
 * @作者 ${yongming}
 * @创建日期 2019/8/2 11:25
 * @说明
 */
class MyViewModel
@Inject constructor(private val apiService: ApiService): BaseViewModel(){

}