package com.cfox.fbannerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private CardView mBtnOpenBanner, mBtnOpenBannerForList, mBtnOpenBannerForListRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = null;
        mBtnOpenBanner = (CardView) findViewById(R.id.open_banner);
        mBtnOpenBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,BannerActivity.class);
                startActivity(intent);

            }
        });

        mBtnOpenBannerForList = (CardView) findViewById(R.id.open_banner_list);
        mBtnOpenBannerForList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListViewBannerActivity.class);
                startActivity(intent);
            }
        });

        mBtnOpenBannerForListRef = (CardView) findViewById(R.id.open_banner_list_ref);
        mBtnOpenBannerForListRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListViewRefreshBannerActivity.class);
                startActivity(intent);
            }
        });

    }
}
