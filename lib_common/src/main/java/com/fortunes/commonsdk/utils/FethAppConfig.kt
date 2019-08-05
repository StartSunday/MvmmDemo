package com.qtyc.extremecar.baselibrary.utils

import com.fortunes.commonsdk.utils.SharedPreferencesUtils


/**
 * @author sun
 * @data 2018-12-25
 * @Explain 全局能用
 */
class FethAppConfig {
    companion object {
         fun isLogin()= SharedPreferencesUtils.getParam("isLogin",false)!!
    }
}