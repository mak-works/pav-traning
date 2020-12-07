package com.learning.androidlearning.movemarker.taxiui.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.res.ResourcesCompat;

import com.learning.androidlearning.R;

public class Utils {

    public static Drawable getDrawableRes(Resources resources) {
        return ResourcesCompat.getDrawable(resources, R.drawable.mybuttonbackground, null);
    }
}
