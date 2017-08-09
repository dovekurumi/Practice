package com.che.practice.draw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.drawCircle(getWidth()/ 4, getHeight()/4, getWidth()/8, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp2px(1));
        canvas.drawCircle(getWidth() /4 * 3, getHeight()/4, getWidth()/8, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth()/4, getHeight()/4*3, getWidth()/8, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(dp2px(20));
        canvas.drawCircle(getWidth()/4 * 3, getHeight()/4 * 3 , getWidth()/8, paint);
    }

    public int dp2px(float dp){
        float scale = getContext().getResources().getDisplayMetrics().density;

       return (int) (scale * dp + 0.5f);
    }
}
