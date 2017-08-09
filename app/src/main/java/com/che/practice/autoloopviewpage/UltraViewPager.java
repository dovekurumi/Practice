package com.che.practice.autoloopviewpage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.che.practice.R;
import com.che.practice.autoloopviewpage.adapter.UltraViewPagerAdapter;
import com.che.practice.autoloopviewpage.transformer.UltraDepthScaleTransformer;

/**
 * Created by dove on 2017/8/3.
 */

public class UltraViewPager extends RelativeLayout{

    private ViewPager mViewPager;
    private int mCurrentItem;

    public UltraViewPager(Context context) {
        this(context, null);
    }

    public UltraViewPager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UltraViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        size = new Point();
        maxSize = new Point();
        initView(context, attrs);
    }

    TimerHandler.TimerHandlerListener mTimerHandlerListener = new TimerHandler.TimerHandlerListener() {
        @Override
        public void callBack() {
            int nextPage = 0;
            if (mViewPager != null && mViewPager.getAdapter() != null
                    && mViewPager.getAdapter().getCount() > 0){

                if (mViewPager.getCurrentItem() < mViewPager.getAdapter().getCount() - 1)
                    nextPage = mViewPager.getCurrentItem() + 1;

                mViewPager.setCurrentItem(nextPage, true);
            }
        }
    };

    TimerHandler mTimerHandler;
    private float ratio = Float.NaN;

    private final Point size;
    private final Point maxSize;

    //Maximum width of child when enable multiScreen.
    private int maxWidth = -1;

    //Maximum height of child when enable multiScreen.
    private int maxHeight = -1;

    private void initView(Context context, AttributeSet attrs) {
        this.mViewPager = new ViewPager(context);
        //mViewPager.setClipChildren(false);
        addView(mViewPager);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        configView(context, attrs);
    }

    private void configView(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.UltraViewPager);

        int taInt = ta.getInt(R.styleable.UltraViewPager_upv_autoscroll, 0);

        boolean aBoolean = ta.getBoolean(R.styleable.UltraViewPager_upv_infiniteloop, false);

        ta.recycle();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!Float.isNaN(ratio)) {
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (widthSize / ratio), MeasureSpec.EXACTLY);
        }

        size.set(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
        if (maxWidth >= 0 || maxHeight >= 0){
            maxSize.set(maxWidth, maxHeight);
            constrainTo(size, maxSize);
            widthMeasureSpec = MeasureSpec.makeMeasureSpec(size.x, MeasureSpec.EXACTLY);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(size.y, MeasureSpec.EXACTLY);
        }

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

    }

    private void constrainTo(Point size, Point maxSize) {
        if (maxSize.x >= 0){
            if (size.x > maxSize.x){
                size.x = maxSize.x;
            }
        }
        if (maxSize.y >= 0){
            if (size.y > maxSize.y){
                size.y = maxSize.y;
            }
        }
    }


    public void setMaxWidth(int width) {
        maxWidth = width;
    }

    public void setMaxHeight(int height) {
        maxHeight = height;
    }


    public void setCurrentItem(int currentItem) {
        mViewPager.setCurrentItem(currentItem);
    }

    public void setPageTransformer(boolean b, UltraDepthScaleTransformer ultraDepthScaleTransformer) {
        mViewPager.setPageTransformer(b, ultraDepthScaleTransformer);
    }

    public void setAdapter(UltraViewPagerAdapter pagerAdapter) {
        mViewPager.setAdapter(pagerAdapter);
    }

    public void startTimer(){
        if (mTimerHandler == null || !mTimerHandler.isStopped) return;
        mTimerHandler.mListener = mTimerHandlerListener;
        mTimerHandler.removeCallbacksAndMessages(null);
        mTimerHandler.sendEmptyMessageDelayed(TimerHandler.MSG_TIMER_ID, mTimerHandler.millisecond);
        mTimerHandler.isStopped = false;
    }

    public void stopTimer(){
        if (mTimerHandler == null || mTimerHandler.isStopped) return;
        mTimerHandler.removeCallbacksAndMessages(null);
        mTimerHandler.mListener = null;
        mTimerHandler.isStopped = true;
    }

    public void setAutoScrollMilli(int scrollMilli){
        if (0 == scrollMilli) return;
        if (mTimerHandler != null){
            stopTimer();
            mTimerHandler = null;
        }
        mTimerHandler = new TimerHandler(mTimerHandlerListener, scrollMilli);
        startTimer();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (mTimerHandler != null){
            if (action == MotionEvent.ACTION_DOWN)
                stopTimer();
            if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL){
                startTimer();
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
