package com.framgia.awesomecity.utils.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.framgia.awesomecity.R;
import com.framgia.awesomecity.data.model.Table;
import com.framgia.awesomecity.screen.BaseViewModel;
import com.squareup.picasso.Picasso;

import static android.widget.RelativeLayout.ALIGN_PARENT_LEFT;
import static android.widget.RelativeLayout.ALIGN_PARENT_START;
import static android.widget.RelativeLayout.ALIGN_PARENT_TOP;

/**
 * Created by tmd on 23/08/2017.
 */
public class ImageTable extends android.support.v7.widget.AppCompatImageView {
    private Context mContext;
    private BaseViewModel mViewModel;
    private Table mTable;
    private RelativeLayout.LayoutParams mParams;

    public ImageTable(Context context) {
        super(context);
    }

    public ImageTable(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageTable(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ImageTable(Context context, BaseViewModel viewModel,
                      Table table) {
        super(context);
        mContext = context;
        mViewModel = viewModel;
        mTable = table;
        initTable();
    }

    private void initTable() {
        mParams = new RelativeLayout.LayoutParams(
            (int) mTable.getLengthX(), (int) mTable.getLengthY());
        mParams.addRule(ALIGN_PARENT_LEFT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mParams.addRule(ALIGN_PARENT_START);
        }
        mParams.addRule(ALIGN_PARENT_TOP);
        mParams.leftMargin = (int) mTable.getPosY();
        mParams.topMargin = (int) mTable.getPosX();
        setLayoutParams(mParams);
        Picasso.with(mContext)
            .load(mTable.getImage())
            .placeholder(R.mipmap.food)
            .into(this);
    }
}
