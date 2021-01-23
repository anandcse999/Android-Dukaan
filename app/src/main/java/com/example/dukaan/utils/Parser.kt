package com.example.dukaan.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

object Parser {
    fun parseJSONData( mContext: Context): String? {
        var JSONString: String? = null
        JSONString = try {
            val inputStream: InputStream = mContext!!.assets.open("data.json")
            val sizeOfJSONFile: Int = inputStream.available()
            val bytes = ByteArray(sizeOfJSONFile)
            inputStream.read(bytes)
            inputStream.close()
            String(bytes, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return JSONString
    }
}