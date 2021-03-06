package com.siri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    private final GestureDetector gestureDetector;
    private final ClickListener clickListener;

    RecyclerTouchListener(final Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(final MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(final MotionEvent e) {
                final View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(final RecyclerView rv, final MotionEvent e) {
        final View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(final RecyclerView rv, final MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(final boolean disallowIntercept) {

    }

    interface ClickListener {
        void onClick(final View view, final int position);

        void onLongClick(final View view, final int position);
    }
}