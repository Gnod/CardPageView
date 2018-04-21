package com.gnodstudio.demo.carddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by DLC on 2018/4/1.
 */

public class CardFragment extends Fragment {
    private int mPosition;

    public CardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        mPosition = bundle.getInt("Pos");

        return inflater.inflate(R.layout.card_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private int[] colors = new int[] {
            R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5
    };

    private void init(View view) {

        final ImageView imageView = view.findViewById(R.id.test_image);
        imageView.setImageDrawable(getContext().getDrawable(colors[mPosition % colors.length]));

        int screenWidth = Utils.getScreenWidth(getContext());

        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        if (params != null) {
            params.width = (int) (screenWidth * Utils.CARD_WIDTH_SCREEN_RATIO);
            params.height = params.width;
        }
    }


}
