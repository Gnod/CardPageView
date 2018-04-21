package com.gnodstudio.demo.carddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.gnodstudio.demo.carddemo.Utils.CARD_WITH_MIN_SCALE_RATIO;
import static com.gnodstudio.demo.carddemo.Utils.CARD_WIDTH_SCREEN_RATIO;

/**
 * Created by DLC on 2018/4/21.
 */

public class MainActivity extends AppCompatActivity {

    private static final float MIN_SCALE = CARD_WITH_MIN_SCALE_RATIO / CARD_WIDTH_SCREEN_RATIO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final ViewPager viewPager = findViewById(R.id.test_viewpager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        final float margin = Utils.getScreenWidth(this)
                * ((1 - CARD_WITH_MIN_SCALE_RATIO) + (1 - CARD_WIDTH_SCREEN_RATIO))/2
                - Utils.dpToPix(this, 16);

        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {

                int width = page.getWidth();

                float scaleFactor = 1 - (1 - MIN_SCALE) * Math.min(1f, Math.abs(position));
                float offset = -margin * position;

                if (position < -1) {
                    float finalScaleFactor = (1 - Math.min(1f, Math.abs(-2 - position)) * (1 - MIN_SCALE));
                    offset += width * (finalScaleFactor - scaleFactor);
                } else if (position > 1) {
                    float finalScaleFactor = (1 - Math.min(1f, Math.abs(2 - position)) * (1 - MIN_SCALE));
                    offset -= width * (finalScaleFactor - scaleFactor);
                }
                if (position < 0) {
                    page.setTranslationX(offset);
                } else {
                    page.setTranslationX(offset);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            }
        });

    }
}
