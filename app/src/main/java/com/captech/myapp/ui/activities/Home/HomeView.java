package com.captech.myapp.ui.activities.Home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.captech.myapp.R;
import com.captech.myapp.ui.activities.BaseView;
import com.captech.myapp.ui.activities.Video.VideoView;
import com.captech.myapp.ui.views.ToolbarLayout;
import com.captech.myapp.utilities.Constant;

import butterknife.BindView;

/**
 * Created by lorence on 03/11/2017.
 * @Run: https://stackoverflow.com/questions/2888508/how-to-change-the-font-on-the-textview
 * => Font
 *
 * @Run: https://developer.android.com/training/implementing-navigation/lateral.html
 *
 */

public class HomeView extends BaseView implements View.OnClickListener{

    @BindView(R.id.toolbar_layout)
    public ToolbarLayout mToolbarLayout;

    @Override
    public void onClick(View v) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.home_screen;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void activityCreated() {
        initViews();
        initAttributes();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.ACCESS_WIFI_STATE},
                    Constant.Permissions.ACCESS_INTERNET);
        } else {
            // startActivity(new Intent(HomeView.this, VideoView.class));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constant.Permissions.ACCESS_INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0) {
                    for (int permissionId : grantResults) {
                        if (permissionId != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                startActivity(new Intent(HomeView.this, VideoView.class));
            }
        }
    }

    private void initViews() {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initAttributes() {
        mToolbarLayout.getToolbar().setBackgroundColor(ContextCompat.getColor(this, R.color.action_bar_color));
        mToolbarLayout.getToolbar().setTitle("Home");
        mToolbarLayout.getTextViewTitle(mToolbarLayout.getToolbar()).setTypeface(getTypeFace(FONT_ROBOTO_MODE.MEDIUM));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
