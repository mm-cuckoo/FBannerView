package com.cfox.fbanlib;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class FBannerPageAdapter<T> {

    private List<T> mDatas = new ArrayList<>();

    public FBannerPageAdapter(List<T> ts){
        mDatas.clear();
        if (ts == null){
            return;
        }
        mDatas.addAll(ts);
    }

    public void setData(List<T> ts){
        mDatas.clear();
        if (ts == null){
            return;
        }
        mDatas.addAll(ts);
    }

    public List<T> getDatas(){
        return mDatas;
    }


    public abstract void onPageSelected(T t, int position);

    public abstract View onLoadView(LayoutInflater inflater, ImageView view, T t, int position);

    public void bindEvent(View view , T t){}

    public float getPageWidth(int position) {
        return 1.f;
    }
}
