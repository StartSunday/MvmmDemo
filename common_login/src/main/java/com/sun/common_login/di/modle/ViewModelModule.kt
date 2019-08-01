package com.sun.common_login.di.modle

import androidx.lifecycle.ViewModel
import com.mou.basemvvm.android.ViewModelKey
import com.sun.common_login.mvvm.viewmodel.LoginViewModel
import com.sun.common_login.mvvm.viewmodel.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/***
 * 该类主要提供整个module的ViewModel的实例
 * 例如:
 *  @Binds
 *  @IntoMap
 *  @ViewModelKey(HomeViewModel::class)
 *  abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
 **/

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun bindRegisterViewModel(viewModel: RegisterViewModel): ViewModel
}