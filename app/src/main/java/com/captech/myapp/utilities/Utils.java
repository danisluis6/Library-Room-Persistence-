package com.captech.myapp.utilities;

import android.content.ActivityNotFoundException;

import com.captech.myapp.ui.activities.BaseView;

/**
 *
 * Created by lorence on 03/11/2017.
 */

public class Utils {

    public static String makeLogTag(Class<BaseView> activityClass) throws ActivityNotFoundException {
        return activityClass.getSimpleName();
    }
}
