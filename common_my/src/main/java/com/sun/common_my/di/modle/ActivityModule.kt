package com.sun.common_my.di.modle

import dagger.Module


/***
 * 这里存放module中的Dagger需要注入的Activity的实例
 * 例如:
 *   @ContributesAndroidInjector
 *   abstract fun contributeXXActivity(): XXActivity
 */
@Module
abstract class ActivityModule {

}