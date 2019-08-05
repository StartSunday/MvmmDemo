package com.sun.common_home.mvvm.view


import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.fortunes.commonsdk.utils.NavigationUtils
import com.mou.basemvvm.base.BaseFragment
import com.mou.basemvvm.helper.extens.bindDialogOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.qtyc.extremecar.baselibrary.utils.Tip.Companion.toast
import com.sun.common_home.mvvm.viewmodel.HomeViewModel

import com.sun.common_home.R
import com.sun.common_home.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 *
 */
@Route(path = RouterConstants.HOME_FRAGMENT)
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getLayoutId(): Int = R.layout.fragment_home

    private val mViewModel by lazy {
        createVM<HomeViewModel>()
    }

    override fun initView() {
        ARouter.getInstance().inject(this)


        //设置viewModel
        mBinding.apply{
            vm = mViewModel
        }
        btn.setOnClickListener {
            mViewModel.getArticle()
                .bindDialogOrLifeCycle(this)
                .onHttpSubscribeNoToast(activity!!){
                    activity!!.toast("成功")
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
