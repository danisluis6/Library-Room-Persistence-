package com.captech.myapp.utilities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.captech.myapp.R;
import com.captech.myapp.userinterfaces.activities.BaseActivity;

import java.io.ByteArrayOutputStream;

/**
 *
 * Created by lorence on 03/11/2017.
 */

public class Utils {

    public static byte[] convertToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static Bitmap convertToBitmap(byte[] bitmapdata) {
        return BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.length);
    }

    public static int[] getArrayColors(Context context) {
        return context.getResources().getIntArray(R.array.colors);
    }

    public static String makeLogTag(Class<BaseActivity> activityClass) throws ActivityNotFoundException {
        return activityClass.getSimpleName();
    }
}
