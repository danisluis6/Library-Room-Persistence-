package com.captech.roomdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.captech.roomdemo.R;

import java.io.ByteArrayOutputStream;

/**
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

}
