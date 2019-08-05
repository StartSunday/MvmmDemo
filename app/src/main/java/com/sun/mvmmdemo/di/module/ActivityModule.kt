package com.sun.mvmmdemo.di.module

import com.jess.arms.di.scope.ActivityScope
import com.sun.mvmmdemo.mvvm.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [com.sun.common_home.di.modle.FragmentModule::class,com.sun.common_my.di.modle.FragmentModule::class])
    abstract fun  contributeMainActivity(): MainActivity

}