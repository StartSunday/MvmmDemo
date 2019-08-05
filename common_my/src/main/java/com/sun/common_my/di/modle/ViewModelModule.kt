package com.sun.common_my.di.modle

import androidx.lifecycle.ViewModel
import com.mou.basemvvm.android.ViewModelKey
import com.sun.common_my.mvvm.viewmodel.MyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/***
 * 该类主要提供整个module的ViewModel的实例
 * 例如:
 *  @Binds
 *  @IntoMap
 *  @ViewModelKey(MyViewModel::class)
 *  abstract fun bindHomeViewModel(viewModel: MyViewModel): ViewModel
 **/

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    abstract fun bindMyViewModel(viewModel: MyViewModel): ViewModel
}