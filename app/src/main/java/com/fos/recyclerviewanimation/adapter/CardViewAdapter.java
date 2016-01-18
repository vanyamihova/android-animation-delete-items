package com.fos.recyclerviewanimation.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.fos.recyclerviewanimation.R;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Vanya Mihova on 11/23/2015.
 */
public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public void removeItem(int position) {
        notifyItemRemoved(position);
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.card_view)CardView cardView;
        @Bind(R.id.btn_delete)Button btnDelete;

        public CardViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            View parent = (View) v.getParent();
            Animation animation = AnimationUtils.loadAnimation(parent.getContext(), R.anim.disapear_card_view);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) { }

                @Override
                public void onAnimationEnd(Animation animation) {
                    removeItem(getAdapterPosition());
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }
            });
            parent.startAnimation(animation);
        }
    }



}
