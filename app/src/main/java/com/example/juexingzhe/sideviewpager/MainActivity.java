package com.example.juexingzhe.sideviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int[] RES = new int[]{R.mipmap.image1, R.mipmap.image2, R.mipmap.image3,
    R.mipmap.image4};

    private List<SideBean> datas = new LinkedList<>();

    private SideViewPager sideViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sideViewPager = (SideViewPager)findViewById(R.id.side_vp);

        for (int i = 0; i < RES.length; i++){
            SideBean sideBean = new SideBean(RES[i], "haha0", "hehe0", "left", RES[i], "haha1", "hehe1", "right");
            datas.add(sideBean);
        }

        sideViewPager.setSideBannerAdapter(new SideViewPager.SideBannerAdapter() {
            @Override
            public int getCount() {
                return datas.size();
            }

            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(MainActivity.this, "点击了" + String.valueOf(position), Toast.LENGTH_SHORT).show();

            }

            @Override
            public SideViewHolderCreator getSideViewHolderCreator() {
                return new SideViewHolderCreator() {
                    @Override
                    public SideViewHolder createSideViewHolder() {

                        if (datas.size() == 1){
                            return new ImageSideViewHolder();
                        }else {
                            return new RatioSideViewHolder();
                        }
                    }
                };
            }

            @Override
            public Object getItemData(int position) {
                return datas.get(position);
            }
        });

    }
}
