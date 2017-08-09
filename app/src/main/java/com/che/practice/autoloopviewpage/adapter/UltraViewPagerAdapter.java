package com.che.practice.autoloopviewpage.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dove on 2017/8/3.
 */

public class UltraViewPagerAdapter extends PagerAdapter {

    private static final int INFINITE_RATIO = 500;
    private boolean enableLoop = false;
    private PagerAdapter adapter;
    private int infiniteRatio;

    public UltraViewPagerAdapter(PagerAdapter adapter){
        this.adapter = adapter;
        this.infiniteRatio = INFINITE_RATIO;
    }

    @Override
    public int getCount() {
        int count;
        if (enableLoop){
            if (adapter.getCount() == 0){
                count = 0;
            }else {
                count = adapter.getCount() * infiniteRatio;
            }
        }else {
            count = adapter.getCount();
        }
        return count;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = getRealPosition(position);
        Object item = adapter.instantiateItem(container, realPosition);
//        View childView = null;
//        if (item instanceof View)  childView = (View) item;
//        ViewPager viewPager = (ViewPager) container;
//        int childCount = viewPager.getChildCount();
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int realPosition = getRealPosition(position);
        adapter.destroyItem(container, realPosition, object);
    }

    int getRealPosition(int count){
        int realPosition = count;
        if (enableLoop){
            realPosition = count % adapter.getCount();
        }
        return realPosition;
    }


    public void setEnableLoop(boolean status){
        this.enableLoop = status;
    }

    public void setInfiniteRatio(int infiniteRatio){
        this.infiniteRatio = infiniteRatio;
    }
}
