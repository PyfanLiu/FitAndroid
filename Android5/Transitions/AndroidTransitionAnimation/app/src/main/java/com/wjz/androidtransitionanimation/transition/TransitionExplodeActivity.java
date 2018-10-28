package com.wjz.androidtransitionanimation.transition;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.transitionseverywhere.Explode;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.Transition;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.wjz.androidtransitionanimation.R;

/**
 * Copyright (c) 2018 SHARP CORPORATION
 *
 * @author wujiazhen
 * @file com.wjz.androidtransitionanimation.transition.TransitionExplodeActivity
 * <p>
 * [DESCRIPTION]
 * @change [DATE] [EDITOR] [MODEL] [TYPE] [COMMENT]
 */

public class TransitionExplodeActivity extends AppCompatActivity {
    private RecyclerView mRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_explode);

        mRV = (RecyclerView) findViewById(R.id.rv_explode);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mRV.setLayoutManager(gridLayoutManager);
        mRV.setAdapter(new RVAdapter());

        mRV.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10, 10, 10, 10);
            }
        });


    }
}

class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {


    private RecyclerView mRecyclerView;

    @Override
    public RVViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.explode_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RVViewHolder holder, int position) {
        holder.itemView.setOnClickListener(clickedView -> letsExplodeIt(clickedView));
    }

    private void letsExplodeIt(View clickedView) {
        // save rect of view in screen coordinated
        final Rect viewRect = new Rect();
        clickedView.getGlobalVisibleRect(viewRect);

        TransitionSet set = new TransitionSet()
                .addTransition(new Explode().setEpicenterCallback(new Transition.EpicenterCallback() {
                    @Override
                    public Rect onGetEpicenter(Transition transition) {
                        return viewRect;
                    }
                }).excludeTarget(clickedView, true))
                .addTransition(new Fade().addTarget(clickedView))
                .addListener(new Transition.TransitionListenerAdapter() {
                    @Override
                    public void onTransitionEnd(Transition transition) {
//                        getActivity().onBackPressed();
                    }
                });
        TransitionManager.beginDelayedTransition(mRecyclerView, set);

        // remove all views from Recycler View
        mRecyclerView.setAdapter(null);
    }

    @Override
    public int getItemCount() {
        return 32;
    }

    public class RVViewHolder extends RecyclerView.ViewHolder{


        public RVViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }
}
