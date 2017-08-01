package com.framgia.awesomecity.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by pnam2 on 8/2/2017.
 */

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;

    public ItemDecoration(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        outRect.top = mSpace;
    }
}
