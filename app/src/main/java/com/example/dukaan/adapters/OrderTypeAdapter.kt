package com.example.dukaan.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.R
import com.example.dukaan.models.DetailObj
import com.example.dukaan.models.OrderTypesObj

class OrderTypeAdapter(val mContext: Context, val orderTypeList: List<OrderTypesObj>) : RecyclerView.Adapter<OrderTypeViewHolder>() {
    var previousPosition = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderTypeViewHolder {
        return OrderTypeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.order_type_item, parent, false))
    }

    override fun onBindViewHolder(holder: OrderTypeViewHolder, position: Int) {
        val detailsObj = orderTypeList.get(position)
        if (previousPosition == position) {
            holder.tvName.setTextColor(Color.WHITE)

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
                holder.tvName.setBackground(mContext.getDrawable(R.drawable.order_selected))
            else
                holder.tvName.setBackground(mContext.resources.getDrawable(R.drawable.order_selected))
        } else {
            holder.tvName.setTextColor(Color.DKGRAY)

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP)
                holder.tvName.setBackground(mContext.getDrawable(R.drawable.order_unselect))
            else
                holder.tvName.setBackground(mContext.resources.getDrawable(R.drawable.order_unselect))
        }


        holder.tvName.setTag(position)
        holder.tvName.setText(detailsObj.title + "(" + detailsObj.value + ")")
        holder.tvName.setOnClickListener(View.OnClickListener { v ->
            previousPosition = v.tag as Int
            notifyDataSetChanged()
        })
    }

    override fun getItemCount(): Int {
        return orderTypeList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}