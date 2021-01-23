package com.example.dukaan.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Share {
    @SerializedName("title")
    @Expose
     val title: String? = null
    @SerializedName("sub_title")
    @Expose
     val subTitle: String? = null
    @SerializedName("link")
    @Expose
     val link: String? = null
}