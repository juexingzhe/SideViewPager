package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by juexingzhe on 2017/6/20.
 */

public class RatioSideViewHolder implements SideViewHolder<SideBean>{

    private ImageView imageLeft;
    private ImageView imgRight;
    private TextView tvLeft;
    private TextView tvRight;
    private Button btnLeft;
    private Button btnRight;

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_ratio, null);
        imageLeft = (ImageView) view.findViewById(R.id.vp_ratio_image_0);
        imgRight = (ImageView)view.findViewById(R.id.vp_ratio_image_1);
        tvLeft = (TextView)view.findViewById(R.id.vp_ratio_title_0);
        tvRight = (TextView)view.findViewById(R.id.vp_ratio_title_1);
        btnLeft = (Button)view.findViewById(R.id.vp_ratip_btn_0);
        btnRight = (Button) view.findViewById(R.id.vp_ratip_btn_1);
        return view;
    }

    @Override
    public void onBind(Context context, int position, SideBean data) {
        imageLeft.setImageResource(data.getImageRes0());
        imgRight.setImageResource(data.getImageRes1());
        tvLeft.setText(data.getMainTitle0());
        tvRight.setText(data.getMainTitle1());
        btnLeft.setText(data.getBtnTitle0());
        btnRight.setText(data.getBtnTitle1());
    }
}
