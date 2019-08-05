package com.sun.mvmmdemo.mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.fortunes.commonsdk.utils.NavigationUtils
import com.mou.basemvvm.base.BaseActivity
import com.mou.basemvvm.helper.extens.bindDialogOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.qtyc.extremecar.baselibrary.utils.FethAppConfig
import com.sun.common_home.mvvm.adapter.MyPagerAdapter
import com.sun.common_home.mvvm.view.HomeFragment
import com.sun.mvmmdemo.R
import com.sun.mvmmdemo.databinding.ActivityMainBinding
import com.sun.mvmmdemo.mvvm.viewmodel.MainViewModel
import dagger.android.AndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import android.app.Activity
import com.sun.common_my.mvvm.view.MyFragment


@Route(path = RouterConstants.MAIN_ACTIVITY)
class MainActivity : BaseActivity<ActivityMainBinding>() , HasSupportFragmentInjector {

    @JvmField
    @Inject
    var dispatchingActivityInjector: DispatchingAndroidInjector<Fragment>? = null
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingActivityInjector!!
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    private val mViewModel by lazy {
        createVM<MainViewModel>()
    }

    override fun initView() {
        if (!FethAppConfig.isLogin().toString().toBoolean()){
            NavigationUtils.goLoginActivity()
        }
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
        val fragments = ArrayList<Fragment>()
//        for(i in 0..2){
            val bundle = Bundle()
            val homeFragment : Fragment = HomeFragment()
            bundle.putString("name", "1111")
            homeFragment.arguments = bundle

            val bundle2 = Bundle()
            val myFragment : Fragment = MyFragment()
            bundle2.putString("name", "111122")
            myFragment.arguments = bundle2

            fragments.add(homeFragment)
            fragments.add(myFragment)
//        }

//        val bundle2 = Bundle()
//        bundle2.putString("name", "1111")
//        myFragment.arguments = bundle2
//        fragments.add(myFragment)

        view_pager.adapter = MyPagerAdapter(supportFragmentManager, fragments)

    }
}
