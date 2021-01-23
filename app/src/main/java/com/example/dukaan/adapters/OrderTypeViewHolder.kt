package com.example.dukaan.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.R
import com.example.dukaan.ui.customviews.CustomTextView

class OrderTypeViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    lateinit var tvName:CustomTextView
    init {
        this.tvName=itemView.findViewById(R.id.tvName)
    }
}