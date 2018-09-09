package com.cfox.fbannerview.data;


import com.cfox.fbannerview.bean.BannerBean;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

    public static List getLoopData(){
        List<BannerBean> list = new ArrayList<>();
        BannerBean bean = new BannerBean();
        bean.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536480271724&di=0cf9721ddbd5773109c4b83d8861c077&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F96dda144ad345982cc2e364606f431adcaef84ba.jpg");
        bean.setTitle("美丽风景");
        list.add(bean);

        bean = new BannerBean();
        bean.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536480305155&di=7165609d84209b9592f266fb02eb3f99&imgtype=0&src=http%3A%2F%2Fp3.gexing.com%2FG1%2FM00%2FB9%2F56%2FrBACFFaM_VfRWJE0AAlNClgKv_o422.jpg");
        bean.setTitle("最美深秋");
        list.add(bean);

        bean = new BannerBean();
        bean.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536480359906&di=175c50be0836a257c1be80a11392a6cd&imgtype=0&src=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20141218%2Fsy_77521747364.jpg");
        bean.setTitle("远处");
        list.add(bean);

        bean = new BannerBean();
        bean.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1536480413627&di=429a65d8d11a5afa4cf5e7f69be7f96a&imgtype=0&src=http%3A%2F%2Fpic47.nipic.com%2F20140829%2F11284670_162216228000_2.jpg");
        bean.setTitle("岁月静好");
        list.add(bean);

        return list;

    }
}
