package com.che.practice.draw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.che.practice.SinglePaint;
import com.che.practice.utils.DisplayUtils;


public class Practice6DrawLineView extends View {

    public Practice6DrawLineView(Context context) {
        super(context);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice6DrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawLine() 方法画直线

        SinglePaint paint = SinglePaint.getInstance();

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(DisplayUtils.dp2px(getContext(), 3));
        canvas.drawLine(getWidth()/3, getHeight()/3, getWidth()/3 * 2, getHeight()/3 * 2, paint);

    }
}
