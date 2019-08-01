package com.sun.common_login.di.modle

import com.sun.common_login.mvvm.view.LoginActivity
import com.sun.common_login.mvvm.view.RegisterActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/***
 * 这里存放module中的Dagger需要注入的Activity的实例
 * 例如:
 *   @ContributesAndroidInjector
 *   abstract fun contributeXXActivity(): XXActivity
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun conrtibuteLoginActivity() : LoginActivity

    @ContributesAndroidInjector
    abstract fun conrtibuteRegisterActivity() : RegisterActivity
}