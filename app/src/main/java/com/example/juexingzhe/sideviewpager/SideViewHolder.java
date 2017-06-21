package com.example.juexingzhe.sideviewpager;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by juexingzhe on 2017/6/14.
 */

public interface SideViewHolder<T> {

    View getView(Context context);

    void onBind(Context context, int position, T data);

    void onBind(Context context, int position, List<T> datas);

    View getLeftClickView();

    View getRightClickView();

}
