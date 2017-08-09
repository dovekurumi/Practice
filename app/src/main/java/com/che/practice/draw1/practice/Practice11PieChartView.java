package com.che.practice.draw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.che.practice.SinglePaint;
import com.che.practice.utils.DisplayUtils;


public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        SinglePaint paint = SinglePaint.getInstance();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawArc(200, 0, 600, 400, -180, 120, true, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawArc(210, 0, 610, 410, 0, -60, true, paint);

        paint.setColor(Color.parseColor("#FFF8F8F8"));
        canvas.drawArc(210, 0, 610, 410, 10, 10, true, paint);

        paint.setColor(Color.GRAY);
        canvas.drawArc(210, 0, 610, 410, 25, 10, true, paint);

        paint.setColor(Color.GREEN);
        canvas.drawArc(210, 0, 610, 410, 40, 35, true, paint);

        paint.setColor(Color.BLUE);
        canvas.drawArc(210, 0, 610, 410, 80, 95, true, paint);

        paint.setColor(Color.WHITE);




        paint.setTextSize(DisplayUtils.sp2px(getContext(), 18));
        canvas.drawText("饼图", getWidth()/2, getHeight() -100, paint);


        Path path = new Path();

        paint.setTextSize(DisplayUtils.sp2px(getContext(), 12));
        canvas.drawText("Lollipop", 10, 30, paint);
        canvas.drawText("KitKat", 50, 400, paint);
        canvas.drawText("Marshmallow", 700, 50, paint);
        canvas.drawText("Froyo", 700, 220, paint);
        canvas.drawText("Gingerbread", 700, 260, paint);
        canvas.drawText("Ice Cream Sandwich", 700, 320, paint);
        canvas.drawText("Jelly Bean", 700, 370, paint);

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(130, 30);
        path.lineTo(250, 30);
        path.lineTo(259, 59);
        canvas.drawPath(path, paint);

        path.moveTo(140, 400);
        path.rLineTo(110, 0);
        path.rLineTo(9, -59);
        canvas.drawPath(path, paint);

        path.moveTo(541, 59);
        path.rLineTo(29, -9);
        path.rLineTo(120, 0);
        canvas.drawPath(path, paint);

        path.moveTo(610, 210);
        path.rLineTo(80, 0);
        canvas.drawPath(path, paint);

        path.moveTo(603, 260);
        path.rLineTo(80, 0);
        canvas.drawPath(path, paint);

        path.moveTo(577, 320);
        path.rLineTo(120, 0);
        canvas.drawPath(path, paint);

        path.moveTo(510,383);
        path.rLineTo(20, -3);
        path.rLineTo(150, 0);
        canvas.drawPath(path, paint);



    }
}
