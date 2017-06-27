package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static android.view.View.GONE;

/**
 * Created by juexingzhe on 2017/6/21.
 */

public class EqualSideViewHolder implements SideViewHolder<SideBean> {

    private ImageView imageLeft;
    private ImageView imgRight;
    private TextView tvLeft;
    private LinearLayout secondContainer;
    private TextView tvRight;
    private Button btnLeft;
    private Button btnRight;

    @Override
    public View getView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item_equal, null);
        imageLeft = (ImageView) view.findViewById(R.id.vp_equal_image_0);
        imgRight = (ImageView) view.findViewById(R.id.vp_equal_image_1);
        tvLeft = (TextView) view.findViewById(R.id.vp_equal_title_0);
        secondContainer = (LinearLayout)view.findViewById(R.id.vp_equal_second_container);
        tvRight = (TextView) view.findViewById(R.id.vp_equal_title_1);
        btnLeft = (Button) view.findViewById(R.id.vp_equal_btn_0);
        btnRight = (Button) view.findViewById(R.id.vp_equal_btn_1);
        return view;
    }

    @Override
    public void onBind(Context context, int position, SideBean data) {
    }

    @Override
    public void onBind(Context context, int position, List<SideBean> datas) {
        imageLeft.setImageResource(datas.get(0).getImageRes());
        tvLeft.setText(datas.get(0).getMainTitle());
        btnLeft.setText(datas.get(0).getBtnTitle());


        if (datas.size() == 1) {
            secondContainer.setVisibility(View.INVISIBLE);
            imgRight.setVisibility(GONE);
            tvRight.setVisibility(GONE);
            btnRight.setVisibility(GONE);
            return;
        }
        imgRight.setImageResource(datas.get(1).getImageRes());
        tvRight.setText(datas.get(1).getMainTitle());
        btnRight.setText(datas.get(1).getBtnTitle());
    }

    @Override
    public View getLeftClickView() {
        return btnLeft;
    }

    @Override
    public View getRightClickView() {
        return btnRight;
    }
}
