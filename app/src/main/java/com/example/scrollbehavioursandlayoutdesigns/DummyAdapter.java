package com.example.scrollbehavioursandlayoutdesigns;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class DummyAdapter extends RecyclerView.Adapter {

    private Context mContext;


    public DummyAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dummy_item, null);
        return new DummyCell(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }


    public static class DummyCell extends RecyclerView.ViewHolder implements View.OnClickListener {

        private static int green;
        private static int white;
        private static int black;

        TextView textView;

        public DummyCell(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_stanberg);
            itemView.setOnClickListener(this);
            black = itemView.getContext().getResources().getColor(R.color.black);

            if (green == 0)
                green = itemView.getContext().getResources().getColor(R.color.colorPrimary);
            if (white == 0)
                white = itemView.getContext().getResources().getColor(R.color.background_material_light);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View view) {
            boolean isSelected = view.getBackground() != null && ((ColorDrawable) view.getBackground()).getColor() == green;

            int finalRadius = (int) Math.hypot(view.getWidth() / 2, view.getHeight() / 2);

            if (isSelected) {
                view.setBackgroundColor(white);
                textView.setTextColor(black);
            } else {
                Animator animation = ViewAnimationUtils.createCircularReveal(
                        view,
                        view.getWidth() / 2,
                        view.getHeight() / 2,
                        0,
                        finalRadius);

                view.setBackgroundColor(green);
                textView.setTextColor(white);
                animation.start();
            }
        }
    }
}
