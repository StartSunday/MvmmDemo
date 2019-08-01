package com.mou.basemvvm.helper.network


import com.fortunes.commonsdk.network.bean.BaseBean
import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

/**
 * Created by ChenYuYun on 2018/8/10.
 * 处理结果拦截器
 */
class ResponseInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (chain == null) throw ApiException("请求异常")
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.body() != null && response.body()!!.contentType() != null) {
            //复制一个requestBody
            val mediaType = response.body()!!.contentType()
            val content = response.body()!!.string()
            val responseBody = ResponseBody.create(mediaType, content)
            //解析返回结果
            val adapter = GsonBuilder().create().getAdapter(TypeToken.get(BaseBean::class.java))
            val baseEntity = adapter.fromJson(content)
            if (baseEntity.errorCode != 0 ){
                throw ApiException(baseEntity.errorMsg)
            }
            return response.newBuilder().body(responseBody).build()
        }
        return response
    }
}
