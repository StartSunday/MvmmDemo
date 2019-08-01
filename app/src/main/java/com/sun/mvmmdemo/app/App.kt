package com.sun.mvmmdemo.app

import com.mou.basemvvm.base.BaseApplication
import com.sun.mvmmdemo.di.component.DaggerAppComponent

class App : BaseApplication() {
    override fun injectComponent() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

}