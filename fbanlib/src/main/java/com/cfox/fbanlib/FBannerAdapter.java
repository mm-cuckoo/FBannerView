package com.cfox.fbanlib;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class FBannerAdapter<T> extends PagerAdapter{
    private List<T> mBannerDatas;
    private Context mCtx;

    private FBannerPageAdapter mBannerPageAdapter;

    private FBannerListener<T> mClickListener;

    public FBannerAdapter(Context context , FBannerPageAdapter adapter){
        this.mCtx = context;
        this.mBannerPageAdapter = adapter;
        this.mBannerDatas = adapter.getDatas();
    }

    public void setOnClickListener(FBannerListener listener){
        this.mClickListener = listener;
    }


    @Override
    public int getCount() {
        return mBannerDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View view = new ImageView(mCtx);
        View viewBuffer = null;

        if(mBannerPageAdapter != null){
            viewBuffer = mBannerPageAdapter.onLoadView(LayoutInflater.from(mCtx), (ImageView) view, mBannerDatas.get(position),position);
            if(viewBuffer != null){
                mBannerPageAdapter.bindEvent(viewBuffer, mBannerDatas.get(position));
                view = viewBuffer;
                viewBuffer = null;
            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClickListener != null){
                    mClickListener.onItemClickListener( mBannerDatas.get(position),position);
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);

    }

    @Override
    public float getPageWidth(int position) {
        return mBannerPageAdapter.getPageWidth(position);
    }
}
