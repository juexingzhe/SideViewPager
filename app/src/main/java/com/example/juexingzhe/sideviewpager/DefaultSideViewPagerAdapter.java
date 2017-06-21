package com.example.juexingzhe.sideviewpager;

import android.view.View;

import java.util.List;

/**
 * Created by juexingzhe on 2017/6/21.
 */

public class DefaultSideViewPagerAdapter implements SideViewPager.SideViewPagerAdapter<SideBean> {
    private List<SideBean> datas;

    public DefaultSideViewPagerAdapter(List<SideBean> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public void onPageClick(View view, int position) {
    }

    @Override
    public void onLeftViewClick(View view, SideBean data) {
    }

    @Override
    public void onRightViewClick(View view, SideBean data) {
    }


    @Override
    public SideViewHolderCreator getSideViewHolderCreator() {
        return new SideViewHolderCreator() {
            @Override
            public SideViewHolder createSideViewHolder() {
                SideViewHolder sideViewHolder;
                switch (datas.size()) {
                    case 1:
                        sideViewHolder = new ImageSideViewHolder();
                        break;
                    case 2:
                        sideViewHolder = new RatioSideViewHolder();
                        break;
                    default:
                        sideViewHolder = new EqualSideViewHolder();
                        break;
                }
                return sideViewHolder;
            }
        };
    }

    @Override
    public Object getItemData(int position) {
        return datas.get(position);
    }
}
