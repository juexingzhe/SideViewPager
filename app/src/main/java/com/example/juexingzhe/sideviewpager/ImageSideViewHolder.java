package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
        mImageView.setImageResource(data.getImageRes0());
        mMainTitle.setText(data.getMainTitle0());
        mSubTitle.setText(data.getSubTitle0());
    }
}
