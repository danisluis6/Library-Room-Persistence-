package com.captech.myapp.ui.activities.Home.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captech.myapp.R;

/**
 *
 * Created by lorence on 08/11/2017.
 * @Run: http://o7planning.org/vi/10491/huong-dan-su-dung-android-fragment
 * => Done
 *
 * @Run:
 *
 */

public class TopFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_top, container, false);
    }

}
