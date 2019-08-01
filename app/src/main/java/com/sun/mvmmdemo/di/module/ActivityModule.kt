package com.sun.mvmmdemo.di.module

import com.sun.mvmmdemo.mvvm.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun  contributeMainActivity(): MainActivity
}