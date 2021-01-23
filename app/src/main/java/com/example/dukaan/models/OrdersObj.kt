package com.example.dukaan.models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class OrdersObj {
    @SerializedName("name")
    @Expose
     val name:String?=null
    @SerializedName("types")
    @Expose
     val orderTypesObj:List<OrderTypesObj>?=null

}