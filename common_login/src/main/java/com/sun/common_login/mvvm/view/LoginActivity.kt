package com.sun.common_login.mvvm.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.fortunes.commonsdk.utils.NavigationUtils
import com.mou.basemvvm.base.BaseActivity
import com.mou.basemvvm.helper.extens.bindDialogOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.sun.common_login.R
import com.sun.common_login.databinding.ActivityLoginBinding
import com.sun.common_login.mvvm.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

@Route(path = RouterConstants.LOGIN_ACTIVITY)
class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_login

    private val mViewModel by lazy {
        createVM<LoginViewModel>()
    }

    override fun initView() {
        mBinding.apply {
            vm = mViewModel
        }
        login.setOnClickListener {
            mViewModel.getLogin(username = userName.text.toString(),password = password.text.toString())
                .bindDialogOrLifeCycle(this)
                .onHttpSubscribeNoToast(this){
                    NavigationUtils.goMainActivity()
                    finish()
                }
        }
        regist.setOnClickListener {
            NavigationUtils.goRegisterActivity()
        }
    }

    override fun initData() {
    }

}
