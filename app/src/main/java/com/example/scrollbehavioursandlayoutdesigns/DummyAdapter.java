package com.example.scrollbehavioursandlayoutdesigns;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    public static class DummyCell extends RecyclerView.ViewHolder {

        TextView textView;

        public DummyCell(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_stanberg);
        }
    }
}
