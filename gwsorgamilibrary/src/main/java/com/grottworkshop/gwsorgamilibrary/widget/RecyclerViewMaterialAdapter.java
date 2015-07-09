package com.grottworkshop.gwsorgamilibrary.widget;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grottworkshop.gwsorgamilibrary.R;

/**
 * A RecyclerView.Adapter which inject a header to the actual RecyclerView.Adapter
 * Created by fgrott on 7/9/2015.
 */
public class RecyclerViewMaterialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //the constants value of the header view
    static final int TYPE_PLACEHOLDER = Integer.MIN_VALUE;

    //the size taken by the header
    private int mPlaceholderSize = 1;

    //the actual RecyclerView.Adapter
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;

    /**
     * Construct the RecyclerViewMaterialAdapter, which inject a header into an actual RecyclerView.Adapter
     *
     * @param adapter The real RecyclerView.Adapter which displays content
     */
    public RecyclerViewMaterialAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mAdapter = adapter;
    }

    /**
     * Construct the RecyclerViewMaterialAdapter, which inject a header into an actual RecyclerView.Adapter
     *
     * @param adapter         The real RecyclerView.Adapter which displays content
     * @param placeholderSize The number of placeholder items before real items, default is 1
     */
    public RecyclerViewMaterialAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int placeholderSize) {
        this.mAdapter = adapter;
        mPlaceholderSize = placeholderSize;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < mPlaceholderSize)
            return TYPE_PLACEHOLDER;
        else
            return mAdapter.getItemViewType(position - mPlaceholderSize); //call getItemViewType on the adapter, less mPlaceholderSize
    }

    //dispatch getItemCount to the actual adapter, add mPlaceholderSize
    @Override
    public int getItemCount() {
        return mAdapter.getItemCount() + mPlaceholderSize;
    }

    //add the header on first position, else display the true adapter's cells
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case TYPE_PLACEHOLDER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.material_view_pager_placeholder, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }
            default:
                return mAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    //dispatch onBindViewHolder on the actual mAdapter
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_PLACEHOLDER:
                break;
            default:
                mAdapter.onBindViewHolder(holder, position - mPlaceholderSize);
                break;
        }
    }
}