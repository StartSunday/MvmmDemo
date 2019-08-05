package com.sun.common_my.di.modle

import com.jess.arms.di.scope.FragmentScope
import com.sun.common_my.mvvm.view.MyFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/***
 * 该类提供整个module中fragment的实例(这里需要注意所拥有该Fragment的Activity必须实现HasSupportFragmentInjector接口)
 * 例如:
 *   @ContributesAndroidInjector
 *   abstract fun contributeXXFragment(): XXFragment
 */

@Module
abstract class FragmentModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun conrtibuteMyFragment() : MyFragment

}