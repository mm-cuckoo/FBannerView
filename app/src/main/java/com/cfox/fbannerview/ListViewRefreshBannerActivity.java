package com.cfox.fbannerview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import com.andview.refreshview.XRefreshView;
import com.cfox.fbanlib.CircleIndicator;
import com.cfox.fbanlib.FBannerListener;
import com.cfox.fbanlib.FBannerView;
import com.cfox.fbannerview.adapter.BannerAdapter;
import com.cfox.fbannerview.bean.BannerBean;
import com.cfox.fbannerview.data.DataFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewRefreshBannerActivity extends Activity implements AdapterView.OnItemClickListener{

    private XRefreshView mPullToRefreshLayout;
    private ListView mPullListView;

    private SimpleAdapter mSimpleAdapter;

    private List<Map<String,String>> mListData = new ArrayList<Map<String,String>>();

    private Context mContext;

    private FBannerView mViewPager;
    private CircleIndicator mPointView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_ref);
        mContext = this;
        initView();
        initData();
        setListViewData();
    }

    private void initView() {
        mPullToRefreshLayout = (XRefreshView) findViewById(R.id.xrefresh_view);
        // 设置是否可以下拉刷新
        mPullToRefreshLayout.setPullRefreshEnable(true);
        mPullToRefreshLayout.setXRefreshViewListener(new ListViewRefreshListener());
        mPullListView = (ListView) findViewById(R.id.ref_listview);


        View loopView = LayoutInflater.from(this).inflate(R.layout.banner_view,null);
        mPullListView.addHeaderView(loopView);

        mViewPager = (FBannerView) loopView.findViewById(R.id.banner_view);
        mViewPager.setAdapter(new BannerAdapter(DataFactory.getLoopData()));
        mViewPager.setOnItemClickListener(new FBannerListener<BannerBean>() {
            @Override
            public void onItemClickListener(BannerBean loopBean, int position) {
                Toast.makeText(ListViewRefreshBannerActivity.this,"title--->" + loopBean.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

        mPointView = (CircleIndicator) findViewById(R.id.banner_point);
        mPointView.setViewPager(mViewPager);

    }


    private void initData() {
        int index = mListData.size();
        for(int i = index; i < index + 40 ; i ++){
            Map<String,String> map = new HashMap<String,String>();
            map.put("index","index = " + i + ",content" + i);
            mListData.add(map);
        }
    }

    private void setListViewData() {
        mSimpleAdapter = new SimpleAdapter(this,mListData,R.layout.item_listview,new String[]{"index"},new int[]{R.id.index});
        mPullListView.setAdapter(mSimpleAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    private class ListViewRefreshListener extends XRefreshView.SimpleXRefreshListener{
        @Override
        public void onRefresh() {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mPullToRefreshLayout.stopRefresh();
                }
            }, 2000);

        }
    }
}
