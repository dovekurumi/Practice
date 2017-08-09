package com.che.practice.autoloopviewpage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.che.practice.R;
import com.che.practice.autoloopviewpage.adapter.UltraPagerAdapter;
import com.che.practice.autoloopviewpage.adapter.UltraViewPagerAdapter;
import com.che.practice.autoloopviewpage.transformer.UltraDepthScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dove on 2017/8/3.
 */

public class UltraDepthScalePageActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    UltraViewPager ultraViewPager;
    private int[] mImgIds = new int[]{R.drawable.guide_image1,
            R.drawable.guide_image2, R.drawable.guide_image3};
    private List<ImageView> mImageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_depth_scale);
        ButterKnife.bind(this);

        final UltraPagerAdapter adapter = new UltraPagerAdapter(false);
        UltraViewPagerAdapter pagerAdapter = new UltraViewPagerAdapter(adapter);
        pagerAdapter.setEnableLoop(true);
        ultraViewPager.setAdapter(pagerAdapter);
        ultraViewPager.setCurrentItem(pagerAdapter.getCount() / 2);
        ultraViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
        ultraViewPager.setAutoScrollMilli(2000);


    }

    private void initData() {
        for (int imgId : mImgIds) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imgId);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(600, 600));
            mImageViews.add(imageView);
        }
    }

    private int convertDp2Px(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
