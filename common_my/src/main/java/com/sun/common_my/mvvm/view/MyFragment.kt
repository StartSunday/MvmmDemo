package com.sun.common_my.mvvm.view


import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fortunes.commonsdk.core.RouterConstants
import com.mou.basemvvm.base.BaseFragment
import com.sun.common_my.mvvm.viewmodel.MyViewModel

import com.sun.common_my.R
import com.sun.common_my.databinding.FragmentMyBinding
import kotlinx.android.synthetic.main.fragment_my.*


/**
 * A simple [Fragment] subclass.
 *
 */
@Route(path = RouterConstants.My_FRAGMENT)
class MyFragment : BaseFragment<FragmentMyBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_my

    private val mViewModel by lazy {
        createVM<MyViewModel>()
    }

    override fun initView() {
        ARouter.getInstance().inject(this)

        mBinding.apply {
            vm = mViewModel
        }

        val name = arguments?.getString("name")
        tv.text = name
    }

    override fun initData() {
    }


}
