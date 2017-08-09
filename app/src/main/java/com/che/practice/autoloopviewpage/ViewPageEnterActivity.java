package com.che.practice.autoloopviewpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.che.practice.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dove on 2017/8/3.
 */

public class ViewPageEnterActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button mButton;
    @BindView(R.id.button2)
    Button mButton2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_page_demo);
        ButterKnife.bind(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPageEnterActivity.this, UltraDepthScalePageActivity.class));
            }
        });
    }
}
