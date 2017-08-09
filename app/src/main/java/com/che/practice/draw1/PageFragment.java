package com.che.practice.draw1;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.che.practice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dove on 2017/7/28.
 */

public class PageFragment extends Fragment {
    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;
    @BindView(R.id.sampleStub)
    ViewStub mSampleStub;
    @BindView(R.id.practiceStub)
    ViewStub mPracticeStub;

    public static PageFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes", sampleLayoutRes);
        args.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_page, container, false);
        ButterKnife.bind(this,view);

        mSampleStub.setLayoutResource(sampleLayoutRes);
        mSampleStub.inflate();

        mPracticeStub.setLayoutResource(practiceLayoutRes);
        mPracticeStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            sampleLayoutRes = args.getInt("sampleLayoutRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }
}
