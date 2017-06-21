package com.example.juexingzhe.sideviewpager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int[] RES = new int[]{R.mipmap.image1, R.mipmap.image2, R.mipmap.image3};

    private List<SideBean> datas0 = new LinkedList<>();
    private List<SideBean> datas1 = new LinkedList<>();
    private List<SideBean> datas2 = new LinkedList<>();

    private SideViewPager sideViewPager0;
    private SideViewPager sideViewPager1;
    private SideViewPager sideViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sideViewPager0 = (SideViewPager) findViewById(R.id.side_vp_0);
        sideViewPager1 = (SideViewPager) findViewById(R.id.side_vp_1);
        sideViewPager2 = (SideViewPager) findViewById(R.id.side_vp_2);
        //sideViewPager2.setRightMargin(160);
        sideViewPager2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                sideViewPager2.setRightMargin(getDefaultMargin(sideViewPager2));
            }
        });

        initData();
        sideViewPager0.setSideViewPagerAdapter(new MySideViewPagerAdapter(datas0));
        sideViewPager1.setSideViewPagerAdapter(new MySideViewPagerAdapter(datas1));
        sideViewPager2.setSideViewPagerAdapter(new MySideViewPagerAdapter(datas2));

    }

    private void initData() {
        SideBean sideBean;
        for (int i = 0; i < RES.length - 2; i++) {
            if (i % 2 == 0) {
                sideBean = new SideBean(RES[i], "haLeft" + String.valueOf(i), "heLeft" + String.valueOf(i), "left" + String.valueOf(i));
            } else {
                sideBean = new SideBean(RES[i], "haRight" + String.valueOf(i), "heRight" + String.valueOf(i), "right" + String.valueOf(i));
            }
            datas0.add(sideBean);
        }

        for (int i = 0; i < RES.length - 1; i++) {
            if (i % 2 == 0) {
                sideBean = new SideBean(RES[i], "haLeft" + String.valueOf(i), "heLeft" + String.valueOf(i), "left" + String.valueOf(i));
            } else {
                sideBean = new SideBean(RES[i], "haRight" + String.valueOf(i), "heRight" + String.valueOf(i), "right" + String.valueOf(i));
            }
            datas1.add(sideBean);
        }


        for (int i = 0; i < RES.length; i++) {
            if (i % 2 == 0) {
                sideBean = new SideBean(RES[i], "haLeft" + String.valueOf(i), "heLeft" + String.valueOf(i), "left" + String.valueOf(i));
            } else {
                sideBean = new SideBean(RES[i], "haRight" + String.valueOf(i), "heRight" + String.valueOf(i), "right" + String.valueOf(i));
            }
            datas2.add(sideBean);
        }
    }

    private class MySideViewPagerAdapter extends DefaultSideViewPagerAdapter {

        public MySideViewPagerAdapter(List<SideBean> datas) {
            super(datas);
        }

        @Override
        public void onPageClick(View view, int position) {
            Toast.makeText(MainActivity.this, "点击了" + String.valueOf(position), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLeftViewClick(View view, SideBean data) {
            Toast.makeText(MainActivity.this, data.getBtnTitle() + "be clicked", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRightViewClick(View view, SideBean data) {
            Toast.makeText(MainActivity.this, data.getBtnTitle() + "be clicked", Toast.LENGTH_SHORT).show();
        }
    }

    private int getDefaultMargin(View view) {
//        Point point = new Point();
//        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//        wm.getDefaultDisplay().getSize(point);
//        int width = point.x;
//        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
//        float realWidth = width - layoutParams.leftMargin - layoutParams.rightMargin;
//
//        int paddingLeft = view.getPaddingLeft();
//        int paddingRight = view.getPaddingRight();
//
//        realWidth = realWidth - 2 * paddingLeft - 2 * paddingRight - 2 * view.getWidth();

        return (int) (view.getWidth()/ 2.5f);
    }

}
