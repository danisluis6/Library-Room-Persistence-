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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            startActivity(new Intent(HomeView.this, VideoView.class));
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    Constant.Permissions.INTERNET);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Constant.Permissions.INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(new Intent(HomeView.this, VideoView.class));
                } else {
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void initViews() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initAttributes() {
        mToolbarLayout.getToolbar().setBackgroundColor(Color.parseColor("#FF9800"));
        mToolbarLayout.getToolbar().setTitle("Home");
        mToolbarLayout.getTextViewTitle(mToolbarLayout.getToolbar()).setTypeface(getTypeFace(FONT_ROBOTO_MODE.MEDIUM));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
