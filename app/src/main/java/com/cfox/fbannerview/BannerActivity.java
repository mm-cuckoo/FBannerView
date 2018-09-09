package com.cfox.fbannerview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.cfox.fbanlib.CircleIndicator;
import com.cfox.fbanlib.FBannerListener;
import com.cfox.fbanlib.FBannerView;
import com.cfox.fbannerview.adapter.BannerAdapter;
import com.cfox.fbannerview.adapter.MultiPageAdapter;
import com.cfox.fbannerview.bean.BannerBean;
import com.cfox.fbannerview.data.DataFactory;

public class BannerActivity extends Activity {
    private FBannerView mViewPager;
    private CircleIndicator mPointView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        setBanner1();
        setBanner2();
        setBanner3();
        setBanner4();
    }

    private void setBanner1() {
        FBannerView viewPager = (FBannerView) findViewById(R.id.banner_view);
        viewPager.openShowMultiPage(true);
        viewPager.setAdapter(new BannerAdapter(DataFactory.getLoopData()));
        viewPager.setOnItemClickListener(mItemListener);
        CircleIndicator pointView = (CircleIndicator) findViewById(R.id.banner_point);
        pointView.setViewPager(viewPager);
    }

    private void setBanner2() {
        FBannerView viewPager = (FBannerView) findViewById(R.id.multi_banner_view);
        viewPager.openShowMultiPage(true);
        viewPager.setAdapter(new MultiPageAdapter(DataFactory.getLoopData()));
        viewPager.setOnItemClickListener(mItemListener);
        viewPager.setPageMargin(20);
        CircleIndicator pointView = (CircleIndicator) findViewById(R.id.multi_bannner_point);
        pointView.setViewPager(viewPager);
    }

    private void setBanner3() {

    }

    private void setBanner4() {

    }

    private FBannerListener<BannerBean> mItemListener = new FBannerListener<BannerBean>() {
        @Override
        public void onItemClickListener(BannerBean bannerBean, int position) {
            Toast.makeText(BannerActivity.this,"title--->" + bannerBean.getTitle(),Toast.LENGTH_SHORT).show();

        }
    };
}
