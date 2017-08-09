package com.che.practice.draw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.che.practice.SinglePaint;
import com.che.practice.utils.DisplayUtils;


public class Practice7DrawRoundRectView extends View {

    public Practice7DrawRoundRectView(Context context) {
        super(context);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice7DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形

        SinglePaint paint = SinglePaint.getInstance();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);

        canvas.drawRoundRect(getWidth()/3 , getHeight()/5 * 2 , getWidth()/3 * 2, getHeight()/5 *3 ,
                DisplayUtils.dp2px(getContext(), 20), DisplayUtils.dp2px(getContext(), 10), paint);
    }
}
