package com.example.dukaan.models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class DetailObj {
    @SerializedName("title")
    @Expose
     val title:String?=null
    @SerializedName("value")
    @Expose
     val value:String?=null
}