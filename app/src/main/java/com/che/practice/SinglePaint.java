package com.che.practice;

import android.graphics.Paint;

/**
 * Created by dove on 2017/7/27.
 */

public class SinglePaint extends Paint{
    private static SinglePaint ourInstance;

    public static SinglePaint getInstance() {
        if (ourInstance == null){
            synchronized (SinglePaint.class){
                if (ourInstance == null){
                    ourInstance = new SinglePaint();
                }
            }
        }
        ourInstance.setAntiAlias(true);
        return ourInstance;
    }

    private SinglePaint() {
    }
}
