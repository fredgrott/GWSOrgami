package com.grottworkshop.gwsorgamilibrary.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.grottworkshop.gwsobservablescrollview.widget.ObservableScrollView;
import com.grottworkshop.gwsorgamilibrary.R;


/**
 * Created by fgrott on 7/9/2015.
 */
public class ScrollView extends ObservableScrollView {

    private static final String TAG_LINEARLAYOUT = "TAG_LINEARLAYOUT";
    LinearLayout linearLayout;

    public ScrollView(Context context) {
        super(context);
    }

    public ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private boolean constructLinearLayout(View child) {
        if (linearLayout == null) {

            linearLayout = new LinearLayout(getContext());
            linearLayout.setTag(TAG_LINEARLAYOUT);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setVisibility(View.VISIBLE);
            linearLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            super.addView(linearLayout);

            View placeholder = LayoutInflater.from(getContext()).inflate(R.layout.material_view_pager_placeholder, linearLayout, false);
            linearLayout.addView(placeholder);
        }

        return !(child != null && TAG_LINEARLAYOUT.equals(child.getTag()));
    }

    @Override
    public void addView(@NonNull View child) {
        if (constructLinearLayout(child))
            linearLayout.addView(child);
        else
            super.addView(child);
    }

    @Override
    public void addView(@NonNull View child, int index) {
        if (constructLinearLayout(child))
            linearLayout.addView(child, index);
        else
            super.addView(child, index);
    }

    @Override
    public void addView(@NonNull View child, ViewGroup.LayoutParams params) {
        if (constructLinearLayout(child))
            linearLayout.addView(child, params);
        else
            super.addView(child, params);
    }

    @Override
    public void addView(@NonNull View child, int index, ViewGroup.LayoutParams params) {
        if (constructLinearLayout(child))
            linearLayout.addView(child, index, params);
        else
            super.addView(child, index, params);
    }

    @Override
    public void removeAllViews() {
        constructLinearLayout(null);
        linearLayout.removeAllViews();
    }

    @Override
    public void removeViewAt(int index) {
        constructLinearLayout(null);
        linearLayout.removeViewAt(index);
    }

    @Override
    public void removeViews(int start, int count) {
        constructLinearLayout(null);
        linearLayout.removeViews(start, count);
    }
}
