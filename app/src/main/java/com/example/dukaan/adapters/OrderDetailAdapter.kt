package com.example.dukaan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.R
import com.example.dukaan.databinding.OrderDetailItemBinding
import com.example.dukaan.models.OrderDetailsObj

class OrderDetailAdapter(val mContext:Context,val orderDetailList:List<OrderDetailsObj>):RecyclerView.Adapter<OrderDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderDetailViewHolder {
        val overViewItem = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.order_detail_item, parent, false) as OrderDetailItemBinding
        return OrderDetailViewHolder(overViewItem.root,overViewItem )    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        holder.orderDetailBinding.ordersDetail = orderDetailList.get(position)
        holder.orderDetailBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
       return orderDetailList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}