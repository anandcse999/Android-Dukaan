package com.example.dukaan.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dukaan.utils.Parser
import com.example.dukaan.R
import com.example.dukaan.adapters.OrderDetailAdapter
import com.example.dukaan.adapters.OrderTypeAdapter
import com.example.dukaan.adapters.OverViewAdapter
import com.example.dukaan.databinding.FragmentHomeBinding
import com.example.dukaan.models.Data
import com.google.android.material.appbar.AppBarLayout
import com.google.gson.Gson


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    var mContext: Context? = null
    lateinit var data: Data
    var fragmentHomeBinding: FragmentHomeBinding? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        fragmentHomeBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        data = Gson().fromJson(Parser.parseJSONData(mContext!!), Data::class.java)
        fragmentHomeBinding!!.data = data

        val display = activity?.windowManager?.defaultDisplay

        fragmentHomeBinding!!.llTopBar.minimumHeight = (display!!.height * 0.20).toInt()
        val params =
                fragmentHomeBinding!!.nestedScrollView.getLayoutParams() as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as AppBarLayout.ScrollingViewBehavior?
        behavior!!.overlayTop = (((display!!.height * 0.20).toInt()) / 2.5).toInt()
        bindOverView()
        bindOrders()
        bindOrderDetail(0)
        return fragmentHomeBinding!!.root
    }

    private fun bindOverView() {
        var param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        param.setMargins(40, 0, 0, 0)
        fragmentHomeBinding!!.rlOverView.rvOverviewList.layoutParams = param
        fragmentHomeBinding!!.rlOverView.rvOverviewList.layoutManager =
                GridLayoutManager(mContext, 2, GridLayoutManager.VERTICAL, false)

        fragmentHomeBinding!!.rlOverView.rvOverviewList.adapter =
                OverViewAdapter(mContext!!, data.overview!!.overViewItems!!, 2)
    }

    private fun bindOrders() {
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        fragmentHomeBinding!!.rlOrder.rvOrderTypeList.layoutManager = linearLayoutManager

        fragmentHomeBinding!!.rlOrder.rvOrderTypeList.adapter =
                OrderTypeAdapter(mContext!!, data.ordersObj!!.orderTypesObj!!)


    }

    private fun bindOrderDetail(index: Int) {
        val linearLayoutManager = LinearLayoutManager(mContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        fragmentHomeBinding!!.rlOrder.rvOrderDetailList.layoutManager = linearLayoutManager

        fragmentHomeBinding!!.rlOrder.rvOrderDetailList!!.adapter = OrderDetailAdapter(
                mContext!!,
                data.ordersObj!!.orderTypesObj!!.get(index)!!.orderDetailsObj!!
        )

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


}