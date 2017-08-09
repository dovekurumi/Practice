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


public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        SinglePaint paint = SinglePaint.getInstance();

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(DisplayUtils.dp2px(getContext(), 1));
        canvas.drawArc(getWidth()/3, getHeight()/5 * 2, getWidth()/3 * 2, getHeight()/5 * 3, -170, 70, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(getWidth()/3, getHeight()/5 * 2, getWidth()/3 * 2, getHeight()/5 * 3, -10, -80, true, paint);

        canvas.drawArc(getWidth()/3, getHeight()/5 * 2, getWidth()/3 * 2, getHeight()/5 * 3, 10, 170, false, paint);
    }
}
