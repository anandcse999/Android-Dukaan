package com.example.dukaan.models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class OrderDetailsObj {
    @SerializedName("id")
    @Expose
     val id:String?=null
    @SerializedName("is_new")
    @Expose
     val isNew=false
    @SerializedName("date")
    @Expose
     val date:String?=null
    @SerializedName("count")
    @Expose
     val count:String?=null
    @SerializedName("price")
    @Expose
     val price:String?=null
    @SerializedName("transaction")
    @Expose
     val transaction:String?=null
    @SerializedName("transaction_status")
    @Expose
     val transactionStatus=false
}