package com.sun.common_mine.mvvm.view

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.fortunes.commonsdk.core.RouterConstants
import com.fortunes.commonsdk.network.onHttpSubscribeNoToast
import com.guoyang.recyclerviewbindingadapter.ItemClickPresenter
import com.guoyang.recyclerviewbindingadapter.adapter.SingleTypeAdapter
import com.mou.basemvvm.base.BaseActivity
import com.mou.basemvvm.helper.extens.bindStatusOrLifeCycle
import com.mou.basemvvm.helper.extens.toast
import com.mou.basemvvm.helper.listener.RefreshPresenter
import com.sun.common_mine.R
import com.sun.common_mine.databinding.ActivityMineBinding
import com.sun.common_mine.mvvm.viewmodel.MineItemViewModel
import com.sun.common_mine.mvvm.viewmodel.MineViewModel
@Route(path = RouterConstants.MINE_ACTIVITY)
class MineActivity : BaseActivity<ActivityMineBinding>(),RefreshPresenter,ItemClickPresenter<MineItemViewModel> {
    override fun getLayoutId(): Int = R.layout.activity_mine

    private val mViewModel by lazy { createVM<MineViewModel>() }

    private val mAdapter by lazy {
        SingleTypeAdapter(this,R.layout.mine_my_item_order,mViewModel.observableList)
            .apply { this.itemPresenter = this@MineActivity}
    }
    override fun initView() {
        mBinding.apply {
            viewModel = mViewModel
            this.refreshPresenter = this@MineActivity
            recyclerView.adapter = mAdapter
        }
    }

    override fun initData() = loadVMData(true)

    override fun loadData(isRefresh: Boolean) {
        loadVMData(isRefresh)
    }

    override fun onItemClick(v: View, position: Int, item: MineItemViewModel) {
        toast("position= "+position)
    }

    private fun loadVMData(isRefresh: Boolean) =
            mViewModel.getProjectList(isRefresh,2900)
                .bindStatusOrLifeCycle(isRefresh,viewModel = mViewModel, owner = this@MineActivity )
                .onHttpSubscribeNoToast(this@MineActivity){}

}
