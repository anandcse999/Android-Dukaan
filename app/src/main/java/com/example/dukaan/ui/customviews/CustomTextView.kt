package com.example.dukaan.ui.customviews

import android.content.Context
import android.graphics.Canvas
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import java.util.*
import java.util.regex.Pattern

class CustomTextView : AppCompatTextView {

    constructor(context: Context) : super(context) {

        CustomFontUtils.applyCustomFont(this, context, null)

    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        CustomFontUtils.applyCustomFont(this, context, attrs)

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {

        CustomFontUtils.applyCustomFont(this, context, attrs)

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


    }
}