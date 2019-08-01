package com.sun.common_login.mvvm.entity

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.io.Serializable

/**
 * @FileName: LoginBean.java
 * @author: villa_mou
 * @date: 06-16:19
 * @version V1.0 <描述当前版本功能>
 * @desc
 */
//data class LoginResponse(
//    val data: Data,
//    val errorCode: Int,
//    val errorMsg: String
//) : Serializable {
    @SuppressLint("ParcelCreator")
    @Parcelize
    data class LoginBean(
    val chapterTops: @RawValue List<Any>,
    val collectIds: List<Int>,
    val email: String,
    val icon: String,
    val id: Int,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
    ): Parcelable
//}