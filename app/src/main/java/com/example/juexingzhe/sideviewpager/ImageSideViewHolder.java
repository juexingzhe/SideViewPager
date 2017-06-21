package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by juexingzhe on 2017/6/14.
 */
public class ImageSideViewHolder implements SideViewHolder<SideBean>{
    private ImageView mImageView;
    private TextView mMainTitle;
    private TextView mSubTitle;

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_one, null);
        mImageView = (ImageView) view.findViewById(R.id.vp_image);
        mMainTitle = (TextView)view.findViewById(R.id.vp_main_title);
        mSubTitle = (TextView)view.findViewById(R.id.vp_sub_title);
        return view;
    }

    @Override
    public void onBind(Context context, int position, SideBean data) {
        mImageView.setImageResource(data.getImageRes());
        mMainTitle.setText(data.getMainTitle());
        mSubTitle.setText(data.getSubTitle());
    }

    @Override
    public void onBind(Context context, int position, List<SideBean> datas) {
        SideBean sideBean = datas.get(0);
        mImageView.setImageResource(sideBean.getImageRes());
        mMainTitle.setText(sideBean.getMainTitle());
        mSubTitle.setText(sideBean.getSubTitle());
    }

    @Override
    public View getLeftClickView() {
        return null;
    }

    @Override
    public View getRightClickView() {
        return null;
    }
}
