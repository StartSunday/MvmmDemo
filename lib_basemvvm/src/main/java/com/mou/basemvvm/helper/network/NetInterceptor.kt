package com.mou.basemvvm.helper.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/***
 * Created by mou on 2018/8/20.
 * 网络拦截器
 */

class NetInterceptor(private val handler: RequestHandler?) : Interceptor {
    /**
     * 网络请求拦截方法
     */
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {


        val original = chain.request()
        val builder = original.newBuilder()
        builder.addHeader("Content-Type", "application/x-www-form-urlencoded")
//        builder.addHeader("version_code", SystemUtil.getVersionCode(mContext).toString());
        builder.addHeader("platform", "android")
        val request = builder.method(original.method(), original.body()).build()
        return chain.proceed(request)
    }

}