package com.myfirst.itunesapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItunesAdapter extends RecyclerView.Adapter<ItunesViewHolder> {

    private List<ResultsItunes> listResultsItunes;
    private OnClickListener onClickListener;

    public ItunesAdapter(List<ResultsItunes> listResultsItunes,OnClickListener onClickListener) {
        this.listResultsItunes = listResultsItunes;
        this.onClickListener = onClickListener;
    }

    @NonNull

    @Override
    public ItunesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_itunes,parent,false);
        return new ItunesViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItunesViewHolder holder, int position) {
        holder.setData(listResultsItunes.get(position));
    }

    @Override
    public int getItemCount() {
        return listResultsItunes.size();
    }
}
