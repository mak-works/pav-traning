package com.learning.androidlearning.movemarker.kotlin.splash

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.text.TextUtils
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.learning.androidlearning.R

class FontTextView : AppCompatTextView {
    constructor(context: Context) : super(context) {
        init(null, context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs, context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs, context)
    }

    private fun init(attrs: AttributeSet?, context: Context) {
        // TODO Auto-generated constructor stub
        if (attrs != null) {
            @SuppressLint("CustomViewStyleable") val identity = context.obtainStyledAttributes(attrs,
                    R.styleable.defind_font)
            typeface = if (!TextUtils.isEmpty(identity.getString(R.styleable.defind_font_font_name))) {
                Typeface.createFromAsset(context.assets, Constants().FONT_PATH
                        .toString() + identity.getString(R.styleable.defind_font_font_name))
            } else {
                Typeface.createFromAsset(context.assets, Constants().FONT_PATH
                        + context.getString(R.string.font_robot))
            }
            identity.recycle()
        } else {
            typeface = Typeface.createFromAsset(context.assets, Constants().FONT_PATH
                    + context.getString(R.string.font_robot))
        }
    }
}
