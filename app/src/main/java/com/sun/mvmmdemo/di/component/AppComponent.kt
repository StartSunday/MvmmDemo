package com.sun.mvmmdemo.di.component

import android.app.Application
import com.mou.basemvvm.android.FactoryModule
import com.sun.mvmmdemo.app.App
import com.sun.mvmmdemo.di.module.AppModule
import com.sun.mvmmdemo.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FactoryModule::class,
        AppModule::class,// app模块
        ViewModelModule::class,
        com.sun.common_login.di.modle.AppModule::class ,//添加登录模块组件
        com.sun.common_mine.di.modle.AppModule::class, //添加个人中心模块
        com.sun.common_home.di.modle.AppModule::class ,//添加首页模块
        com.sun.common_my.di.modle.AppModule::class //添加首页模块
    ]

)
interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
    fun  inject(application: App)
}