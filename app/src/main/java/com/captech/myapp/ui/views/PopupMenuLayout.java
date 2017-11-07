package com.captech.myapp.ui.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.captech.myapp.R;

import butterknife.ButterKnife;

/**
 * Created by lorence on 07/11/2017.
 *
 * @Run: https://stackoverflow.com/questions/23538929/android-menuitem-custom-layout
 *
 */

public class PopupMenuLayout extends LinearLayout {

    public PopupMenuLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.popup_menu, this, true);
        ButterKnife.bind(this, view);
    }
}
