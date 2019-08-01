package com.sun.mvmmdemo.mvvm.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.fortunes.commonsdk.utils.NavigationUtils
import com.mou.basemvvm.base.BaseActivity
import com.mou.basemvvm.helper.extens.bindDialogOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.sun.mvmmdemo.R
import com.sun.mvmmdemo.databinding.ActivityMainBinding
import com.sun.mvmmdemo.mvvm.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
@Route(path = RouterConstants.MAIN_ACTIVITY)
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_main

    private val mViewModel by lazy {
        createVM<MainViewModel>()
    }

    override fun initView() {
        //设置viewModel
        mBinding.apply{
            vm = mViewModel
        }
        btn.setOnClickListener {
            mViewModel.getArticle()
                .bindDialogOrLifeCycle(this)
                .onHttpSubscribeNoToast(this){
                    toast("成功")
                }
        }
        btn_login.setOnClickListener {
            NavigationUtils.goLoginActivity()
        }
        btn_mine.setOnClickListener {
            NavigationUtils.goMineActivity()
        }
    }

    override fun initData() {
    }
}
