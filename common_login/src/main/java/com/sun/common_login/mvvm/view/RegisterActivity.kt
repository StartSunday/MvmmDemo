package com.sun.common_login.mvvm.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.mou.basemvvm.base.BaseActivity
import com.mou.basemvvm.helper.extens.bindDialogOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.sun.common_login.R
import com.sun.common_login.databinding.ActivityRegisterBinding
import com.sun.common_login.mvvm.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*
@Route(path = RouterConstants.REGISTER_ACTIVITY)
class RegisterActivity : BaseActivity<ActivityRegisterBinding>() {
    override fun getLayoutId(): Int = (R.layout.activity_register)
    private val mViewModel by lazy {
        createVM<RegisterViewModel>()
    }
    override fun initView() {
        mBinding.apply {
            vm = mViewModel
        }
        regist.setOnClickListener {
            mViewModel.getRegister(userName.text.toString(),password.text.toString(),password_again.text.toString())
                .bindDialogOrLifeCycle(this)
                .onHttpSubscribeNoToast(this){
                    toast(it.errorMsg)
                    finish()
                }
        }
    }

    override fun initData() {
    }

}
