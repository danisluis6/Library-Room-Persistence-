package com.captech.myapp.ui.activities;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.captech.myapp.R;
import com.captech.myapp.utilities.Utils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Run: https://github.com/andreasschrade/android-design-template/blob/master/app/src/main/java/de/andreasschrade/androidtemplate/ui/base/BaseView.java
 * @Run: https://stackoverflow.com/questions/34331284/best-example-of-abstract-class-in-android
 * => How to create Class Abstract Activity in Android
 *
 * @Run: https://stackoverflow.com/questions/33295477/how-to-implement-singleton-pattern-in-android/33295561
 * => Done Singleton successfully
 *
 * @Run: https://stackoverflow.com/questions/5702086/how-to-fix-layout-orientation-to-vertical
 * => Done Vertical successfully
 *
 * @Run:  https://stackoverflow.com/questions/43522476/setting-noactionbar-theme-for-a-specific-layout-only
 * => Done
 * => Open Editor Color => <item name="colorPrimaryDark">@color/colorAccent</item>
 */

public abstract class BaseView extends AppCompatActivity {

    /**
     * @Run: https://stackoverflow.com/questions/15078935/what-does-class-mean-in-java
     * =>  is an object that represents the class BaseView on runtime.
     */
    private static String TAG = Utils.makeLogTag(BaseView.class);

    private Context mInstance;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        activityCreated();
    }

    public synchronized Context getInstance() {
        if (mInstance == null) {
            mInstance = this;
        }
        return mInstance;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mainMenu = getMenuInflater();
        mainMenu.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public abstract int getLayoutResId();
    public abstract void activityCreated();

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    public enum FONT_ROBOTO_MODE {
        BLACK, BLACK_ITATLIC, BOLD, BOLD_ITALIC, ITALIC, LIGHT, LIGHT_ITALIC, MEDIUM, MEDIUM_ITALIC, REGULAR, THIN, THIN_ITALIC
    }

    public Typeface getTypeFace(FONT_ROBOTO_MODE mode) {
        switch (mode) {
            case BLACK:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Black.ttf");
            case BLACK_ITATLIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-BlackItalic.ttf");
            case BOLD:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Bold.ttf");
            case BOLD_ITALIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-BoldItalic.ttf");
            case ITALIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Italic.ttf");
            case LIGHT:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Light.ttf");
            case LIGHT_ITALIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-LightItalic.ttf");
            case MEDIUM:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Medium.ttf");
            case MEDIUM_ITALIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-MediumItalic.ttf");
            case REGULAR:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Regular.ttf");
            case THIN:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Thin.ttf");
            case THIN_ITALIC:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-ThinItalic.ttf");
            default:
                return Typeface.createFromAsset(getAssets(),"fonts/roboto/Roboto-Black.ttf");
        }
    }
}
