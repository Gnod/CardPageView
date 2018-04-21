package com.gnodstudio.demo.carddemo;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by DLC on 2018/4/1.
 */

public class Utils {

    public static final float CARD_WIDTH_SCREEN_RATIO = 0.8f;

    public static final float CARD_WITH_MIN_SCALE_RATIO = 0.7f;

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }

    public static float dpToPix(Context context, int size) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, context.getResources().getDisplayMetrics());
    }
}
