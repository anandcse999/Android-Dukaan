package com.example.dukaan.models

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Data {
    @SerializedName("header")
    @Expose
     val header: String? = null
    @SerializedName("share")
    @Expose
     val shareObj: Share? = null
    @SerializedName("overview")
    @Expose
     val overview: Overview? = null
    @SerializedName("orders")
    @Expose
     val ordersObj:OrdersObj?=null
}