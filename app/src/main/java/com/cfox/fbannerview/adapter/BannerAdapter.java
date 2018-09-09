package com.cfox.fbannerview.adapter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cfox.fbanlib.FBannerPageAdapter;
import com.cfox.fbannerview.bean.BannerBean;


import java.util.List;

public class BannerAdapter extends FBannerPageAdapter<BannerBean> {

    public BannerAdapter( @NonNull List<BannerBean> loopBeen) {
        super(loopBeen);
    }

    @Override
    public void onPageSelected(BannerBean loopBean, int position) {
        Log.e("TAG","selected number+++:" + position  + "title:" + loopBean.getTitle());
    }

    @Override
    public View onLoadView(LayoutInflater inflater, ImageView view, BannerBean bannerBean, int position) {
        ((ImageView)view).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(inflater.getContext()).load(bannerBean.getImgUrl()).into(view);
        return view;
    }
}
