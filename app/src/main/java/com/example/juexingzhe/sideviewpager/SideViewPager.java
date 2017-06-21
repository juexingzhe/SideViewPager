package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by juexingzhe on 2017/6/20.
 * TODO:
 * 1.ViewPager Item宽度比可以设置Ratio
 * 2.build
 */

public class SideViewPager extends RelativeLayout {

    private static final int SCREEN_PAGE_LIMIT = 3;
    private static final int PAGE_MARGIN = 0;
    private static final int SCROLLER_DURATION_TIME = 800;     //设置切换速度
    private static final int BANNER_MARGIN_LESS = 5;
    private static final int BANNER_MARGIN_MORE = 80;

    //attr
    private int mPageMargin;
    private int mRightMargin;

    private ViewPager mViewPager;
    private boolean mCountStatus;  //false--Less, true--More
    private SideBannerScroller mSideBannerScroller;
    private int mCurrentPos;

    private BannerAdapter mBannerAdapter;
    private SideViewPagerAdapter mSideViewPagerAdapter;


    public SideViewPager(Context context) {
        super(context);
        init();
    }

    public SideViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        readAttrs(context, attrs);
        init();
    }

    public SideViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        readAttrs(context, attrs);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SideViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        readAttrs(context, attrs);
        init();
    }


    private void readAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SideViewPager);
        mPageMargin = typedArray.getDimensionPixelSize(R.styleable.SideViewPager_page_margin, PAGE_MARGIN);
        mRightMargin = typedArray.getDimensionPixelSize(R.styleable.SideViewPager_right_margin, BANNER_MARGIN_MORE);
        typedArray.recycle();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.side_banner, this, true);
        mViewPager = (ViewPager) view.findViewById(R.id.side_banner_viewpager);
        mViewPager.setOffscreenPageLimit(SCREEN_PAGE_LIMIT);

        setBannerScroll();
    }

    public void setSideMode(boolean mSideMode) {
        if (!mSideMode) {
            mViewPager.setClipChildren(true);
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mViewPager.getLayoutParams();
            layoutParams.rightMargin = mRightMargin;
            mViewPager.setLayoutParams(layoutParams);
            mViewPager.setClipChildren(false);
        }
    }

    public void setPageMargin(int pageMargin) {
        this.mPageMargin = pageMargin;
    }

    public void setRightMargin(int rightMargin) {
        this.mRightMargin = rightMargin;
    }

    public void setSideViewPagerAdapter(SideViewPagerAdapter sideViewPagerAdapter) {
        this.mSideViewPagerAdapter = sideViewPagerAdapter;
        setPages();
    }

    /**
     * 设置数据、布局与绑定数据
     */
    private void setPages() {
        mBannerAdapter = new BannerAdapter(mSideViewPagerAdapter.getSideViewHolderCreator());

        if (mSideViewPagerAdapter.getCount() == 1) {
            mCountStatus = false;
        } else {
            mCountStatus = true;
        }

        if (mSideViewPagerAdapter.getCount() == 1 || mSideViewPagerAdapter.getCount() == 2) {
            processDatasSizeLess();
        } else {
            processDatasSizeMore();
        }

        initViewPager();
    }

    /**
     * 设置手动滑动切换速度
     *
     * @param time
     */
    public void setBannerScrollerSpeed(int time) {
        mSideBannerScroller.setScrollDuration(time);
    }

    /**
     * 数据只有1个情况
     */
    private void processDatasSizeLess() {
        setSideMode(false);
        mBannerAdapter.notifyDataSetChanged();
    }

    private void processDatasSizeMore() {
        setSideMode(true);
        mBannerAdapter.notifyDataSetChanged();
    }

    private void initViewPager() {
        //ViewPager
        mViewPager.setAdapter(mBannerAdapter);
        mCurrentPos = 0;
        mViewPager.setCurrentItem(mCurrentPos);

        mViewPager.setPageMargin(mPageMargin);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPos = position;
                mBannerAdapter.getDataRealPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    /**
     * 设置Banner轮播速度
     */
    private void setBannerScroll() {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mSideBannerScroller = new SideBannerScroller(mViewPager.getContext());
            mScroller.set(mViewPager, mSideBannerScroller);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static class SideBannerScroller extends Scroller {

        private int mDuration = SCROLLER_DURATION_TIME;

        public SideBannerScroller(Context context, int duration) {
            this(context);
            mDuration = duration;
        }

        public SideBannerScroller(Context context) {
            super(context);
        }

        public SideBannerScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public SideBannerScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        public void setScrollDuration(int mDuration) {
            this.mDuration = mDuration;
        }
    }

    private class BannerAdapter extends PagerAdapter {
        private SideViewHolder mSideViewHolder;
        ArrayList<Object> datas;
        private int mLeftDataRealPos;
        private int mRightDataRealPos;

        public BannerAdapter(SideViewHolderCreator sideViewHolderCreator) {
            mSideViewHolder = sideViewHolderCreator.createSideViewHolder();
            if (mSideViewHolder == null) {
                mSideViewHolder = new ImageSideViewHolder();
                mCountStatus = false;
            }
            datas = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return getRealCount();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 获取图片的真实位置
         */
        private int getRealCount() {
            if (mCountStatus) {
                int count = mSideViewPagerAdapter.getCount();
                return count % 2 == 0 ? count / 2 : count / 2 + 1;
            } else {
                return mSideViewPagerAdapter.getCount();
            }

        }

        public void getDataRealPosition(int position) {
            mLeftDataRealPos = position * 2;
            if (position * 2 + 1 < mSideViewPagerAdapter.getCount()) {
                mRightDataRealPos = position * 2 + 1;
            }
        }

        private void clearDataRealPosition() {
            mLeftDataRealPos = -1;
            mRightDataRealPos = -1;
        }

        private boolean isRightDataAvailable() {
            return mRightDataRealPos != -1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            clearDataRealPosition();
            getDataRealPosition(position);
            View view = getView(container, position);
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeAllViews();
            }
            bindView(container, position);
            container.addView(view);
            return view;
        }

        private View getView(ViewGroup container, final int position) {
            View view = mSideViewHolder.getView(container.getContext());
            if (mCountStatus) {
                mSideViewHolder.getLeftClickView().setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mSideViewPagerAdapter != null) {
                            getDataRealPosition(mCurrentPos);
                            mSideViewPagerAdapter.onLeftViewClick(v, mSideViewPagerAdapter.getItemData(mLeftDataRealPos));
                        }
                    }
                });
                mSideViewHolder.getRightClickView().setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mSideViewPagerAdapter != null && isRightDataAvailable()) {
                            getDataRealPosition(mCurrentPos);
                            mSideViewPagerAdapter.onRightViewClick(v, mSideViewPagerAdapter.getItemData(mRightDataRealPos));
                        }
                    }
                });
            } else {
                view.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mSideViewPagerAdapter != null) {
                            mSideViewPagerAdapter.onPageClick(v, position % getRealCount());
                        }
                    }
                });
            }

            return view;
        }

        private void bindView(ViewGroup container, int position) {
            datas.clear();
            datas.add(mSideViewPagerAdapter.getItemData(mLeftDataRealPos));
            if (isRightDataAvailable()) {
                datas.add(mSideViewPagerAdapter.getItemData(mRightDataRealPos));
            }
            mSideViewHolder.onBind(container.getContext(), position, datas);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


    public interface SideViewPagerAdapter<T> {
        /**
         * 获取数据个数
         *
         * @return
         */
        int getCount();

        /**
         * ClickListener
         *
         * @param view
         * @param position
         */
        void onPageClick(View view, int position);

        void onLeftViewClick(View view, T data);

        void onRightViewClick(View view, T data);

        /**
         * @return Holder Creator
         */
        SideViewHolderCreator getSideViewHolderCreator();

        /**
         * 单个数据
         *
         * @param position
         * @return
         */
        Object getItemData(int position);

    }
}
