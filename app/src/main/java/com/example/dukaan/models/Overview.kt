package com.example.dukaan.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Overview {
    @SerializedName("name")
    @Expose
     val name: String? = null
    @SerializedName("items")
    @Expose
     val overViewItems:List<DetailObj>?=null
}