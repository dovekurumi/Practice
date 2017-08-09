package com.che.practice.utils;

import android.content.Context;

/**
 * Created by dove on 2017/7/27.
 */

public class DisplayUtils {

    public static int dp2px(Context context, float dp){
        float scale = context.getResources().getDisplayMetrics().density;

        return (int) (dp * scale + 0.5f);
    }

    public static int sp2px(Context context, float sp){
        float scale = context.getResources().getDisplayMetrics().scaledDensity;

        return (int) (sp * scale + 0.5f);
    }
}
