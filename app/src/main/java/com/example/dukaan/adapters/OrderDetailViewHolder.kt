package com.example.dukaan.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.databinding.OrderDetailItemBinding

class OrderDetailViewHolder(itemView: View, orderDetailBinding: OrderDetailItemBinding) :RecyclerView.ViewHolder(itemView) {
    lateinit var orderDetailBinding:OrderDetailItemBinding
    init {
        this.orderDetailBinding=orderDetailBinding
    }
}