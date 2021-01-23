package com.example.dukaan.adapters

import android.view.View
import android.view.ViewParent
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dukaan.R
import com.example.dukaan.databinding.OverviewItemBinding

class OverViewViewHolder(itemView: View, overViewItem: OverviewItemBinding) : RecyclerView.ViewHolder(itemView) {
lateinit var overViewItem:OverviewItemBinding
lateinit var cvParent:CardView
lateinit var parent:  View
init {
    this.overViewItem=overViewItem
    cvParent=itemView.findViewById(R.id.cvParent)
    this.parent=itemView
}
}