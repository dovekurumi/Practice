package com.che.practice.draw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.che.practice.SinglePaint;
import com.che.practice.utils.DisplayUtils;


public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        SinglePaint paint = SinglePaint.getInstance();

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(DisplayUtils.dp2px(getContext(),1));


        //canvas.drawLine(100, 50, 100, getHeight() - 100, paint);

        int textHeight = getHeight() - 150 + DisplayUtils.dp2px(getContext(), 15);

        Path path = new Path();
        path.moveTo(100, 50);
        path.lineTo(100, getHeight() - 150);
        path.rLineTo(getWidth() - 200, 0);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(DisplayUtils.sp2px(getContext(), 13));
        canvas.drawText("Froyo", 150, textHeight, paint);
        canvas.drawText("GB", 250, textHeight, paint);
        canvas.drawText("ICS", 350, textHeight, paint);
        canvas.drawText("JB", 450, textHeight, paint);
        canvas.drawText("KitKat", 550, textHeight, paint);
        canvas.drawText("L", 700, textHeight, paint);
        canvas.drawText("M", 800, textHeight, paint);

        paint.setTextSize(DisplayUtils.sp2px(getContext(), 18));
        canvas.drawText("直方图", getWidth()/2, getHeight() - 20, paint);

        paint.setColor(Color.GREEN);


        configRect(150, textHeight - 80, 200, canvas, paint);
        //canvas.drawRect(rect, paint);
        configRect(250, textHeight - 50, 300, canvas, paint);
        //canvas.drawRect(rect, paint);
        configRect(350, textHeight - 50, 400, canvas, paint);
        //canvas.drawRect(rect, paint);
        configRect(450, textHeight - 150, 500, canvas, paint);
        configRect(550, textHeight - 250, 600, canvas, paint);
        configRect(700, textHeight - 300, 750, canvas, paint);
        configRect(800, textHeight - 250, 850, canvas, paint);
    }

    private Rect configRect(int left, int top, int right, Canvas canvas, Paint paint) {
        Rect rect = new Rect();
        rect.bottom = getHeight() - 150;
        rect.left = left;
        rect.top = top;
        rect.right = right;

        canvas.drawRect(rect, paint);
        return rect;
    }
}
