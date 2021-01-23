package com.example.dukaan.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.R
import com.example.dukaan.databinding.OverviewItemBinding
import com.example.dukaan.models.DetailObj
import kotlinx.android.synthetic.main.overview_item.view.*

class OverViewAdapter(val mContext: Context, val overviewList: List<DetailObj>,val spanCount:Int) : RecyclerView.Adapter<OverViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverViewViewHolder {

        val overViewItem = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.overview_item, parent, false) as OverviewItemBinding
        return OverViewViewHolder(overViewItem.root, overViewItem)
    }

    override fun onBindViewHolder(holder: OverViewViewHolder, position: Int) {
        holder.overViewItem.detail = overviewList.get(position)
        holder.overViewItem.executePendingBindings()
        val width = mContext.resources.displayMetrics.widthPixels
        var param = RecyclerView.LayoutParams((width/spanCount) - 80, RecyclerView.LayoutParams.WRAP_CONTENT);
        param.setMargins(0, 0, 40, 40)
//        val params = holder.itemView.layoutParams
        holder.parent.cvParent.layoutParams=param


    }

    override fun getItemCount(): Int {
        return overviewList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}