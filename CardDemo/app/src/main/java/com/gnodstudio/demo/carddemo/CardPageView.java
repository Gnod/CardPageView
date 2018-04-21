package com.gnodstudio.demo.carddemo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by DLC on 2018/4/21.
 */

public class CardPageView extends ViewPager {
    private int mCardMargin;
    private float mCardWidthScreenRatio;
    private float mCardScaleRatio;
    private float mCardHeightWidthRatio;

    public CardPageView(Context context) {
        this(context, null);
    }

    public CardPageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        final Resources.Theme theme = context.getTheme();

        TypedArray a = theme.obtainStyledAttributes(attrs, R.styleable.CardPageView, 0 ,0);

        if (a.hasValue(R.styleable.CardPageView_cardMargin)) {
            mCardMargin = a.getDimensionPixelSize(R.styleable.CardPageView_cardMargin, 0);
        }
        if (a.hasValue(R.styleable.CardPageView_widthScreenRatio)) {
            mCardWidthScreenRatio = a.getFloat(R.styleable.CardPageView_widthScreenRatio, 0.8f);
        }
        if (a.hasValue(R.styleable.CardPageView_heightWidthRatio)) {
            mCardHeightWidthRatio = a.getFloat(R.styleable.CardPageView_heightWidthRatio, 1);
        }
        if (a.hasValue(R.styleable.CardPageView_cardScaleRatio)) {
            mCardScaleRatio = a.getFloat(R.styleable.CardPageView_cardScaleRatio, 1);
        }
        a.recycle();

        // core logic: init page transformer
        final float margin = Utils.getScreenWidth(context)
                * ((1 - mCardWidthScreenRatio) + (1 - mCardWidthScreenRatio*mCardScaleRatio)) / 2
                - Utils.dpToPix(context, 16);
        setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {

                int width = page.getWidth();

                float scaleFactor = 1 - (1 - mCardScaleRatio) * Math.min(1f, Math.abs(position));
                float offset = -margin * position;

                if (position < -1) {
                    float finalScaleFactor = (1 - Math.min(1f, Math.abs(-2 - position)) * (1 - mCardScaleRatio));
                    offset += width * (finalScaleFactor - scaleFactor);
                } else if (position > 1) {
                    float finalScaleFactor = (1 - Math.min(1f, Math.abs(2 - position)) * (1 - mCardScaleRatio));
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
