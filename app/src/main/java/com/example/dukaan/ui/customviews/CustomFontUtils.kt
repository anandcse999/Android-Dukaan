package com.example.dukaan.ui.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import com.example.dukaan.R

object CustomFontUtils {
    const val ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android"
    var typefaceAssetPath:String?=null

    private var mTypefaces: HashMap<String, Typeface>? = null
     fun applyCustomFont(customFontTextView: TextView, context: Context, attrs: AttributeSet?) {
        if (mTypefaces == null)
            mTypefaces = HashMap()
        val  attributeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        if (attributeArray != null) {
             typefaceAssetPath = attributeArray.getString(
                    R.styleable.CustomTextView_customTypeface);

//            if (typefaceAssetPath != null) {
//                var typeface: Typeface?=null
//
//                if (mTypefaces!!.containsKey(typefaceAssetPath)) {
//                    typeface = mTypefaces!!.get(typefaceAssetPath)
//                } else {
//                    var assets = context.getAssets();
//                    typeface = Typeface.createFromAsset(assets, typefaceAssetPath);
//                    mTypefaces!!.put(typefaceAssetPath, typeface);
//                }
            if (typefaceAssetPath==null)
                typefaceAssetPath="GalanoGrotesqueRegular.ttf"
                customFontTextView.setTypeface(FontCache.getTypeface(typefaceAssetPath!!, context))

            }
            attributeArray.recycle();

//        }
    }
}