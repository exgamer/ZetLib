package com.citizenzet.zetlib.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Custom implementation of AdapterDataObserver to show empty layouts
 * for RecyclerView when there's no data
 *
 * Usage:
 *
 * adapter.registerAdapterDataObserver(new RVEmptyObserver(recyclerView, emptyView));
 */
public class RVEmptyObserver extends RecyclerView.AdapterDataObserver {
    private View emptyView;
    private View loadingView;
    private RecyclerView recyclerView;

    /**
     * Constructor to set an Empty View for the RV
     */
    public RVEmptyObserver(RecyclerView rv, View ev, View lv) {
        this.recyclerView = rv;
        this.emptyView    = ev;
        this.loadingView    = lv;
        loadingView.setVisibility(View.VISIBLE);
        emptyView.setVisibility( View.GONE);
        recyclerView.setVisibility( View.GONE );
    }

    /**
     * Constructor to set an Empty View for the RV
     */
    public RVEmptyObserver(RecyclerView rv, View ev) {
        this.recyclerView = rv;
        this.emptyView    = ev;
        checkIfEmpty();
    }


    /**
     * Check if Layout is empty and show the appropriate view
     */
    private void checkIfEmpty() {

        if (emptyView != null && recyclerView.getAdapter() != null) {
            boolean emptyViewVisible = recyclerView.getAdapter().getItemCount() == 0;
            emptyView.setVisibility(emptyViewVisible ? View.VISIBLE : View.GONE);
            recyclerView.setVisibility(emptyViewVisible ? View.GONE : View.VISIBLE);
            loadingView.setVisibility(View.GONE);
        }
    }


    /**
     Abstract method implementations
     */
    @Override
    public void onChanged() {
        checkIfEmpty();
    }

    @Override
    public void onItemRangeInserted(int positionStart, int itemCount) {
        checkIfEmpty();
    }

    @Override
    public void onItemRangeRemoved(int positionStart, int itemCount) {
        checkIfEmpty();
    }

}
