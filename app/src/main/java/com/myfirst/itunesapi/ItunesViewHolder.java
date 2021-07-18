package com.myfirst.itunesapi;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItunesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView mIvTrack;
    private Button mBtnPlay, mBtnPause, mBtnDelete;
    private OnClickListener onClickListener;
    private TextView mTvTrackName,mTvArtistName;

    public ItunesViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener = onClickListener;
        initViews();
    }

    private void initViews() {
        mIvTrack = itemView.findViewById(R.id.ivTrack);
        mBtnPlay = itemView.findViewById(R.id.btnPlay);
        mBtnPause = itemView.findViewById(R.id.btnPause);
        mBtnDelete = itemView.findViewById(R.id.btnDelete);
        mTvTrackName = itemView.findViewById(R.id.tvTrackName);
        mTvArtistName = itemView.findViewById(R.id.tvArtistName);
        mBtnPlay.setOnClickListener(this);
        mBtnPause.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
    }

    public void setData(ResultsItunes resultsItunes) {
        Glide.with(mIvTrack).load(resultsItunes.getArtworkUrl100()).into(mIvTrack);
        mTvTrackName.setText(resultsItunes.getTrackName());
        mTvArtistName.setText(resultsItunes.getArtistName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:
                onClickListener.onClickPlay(getAdapterPosition());
                break;
            case R.id.btnPause:
                onClickListener.onClickPause(getAdapterPosition());
                break;
            case R.id.btnDelete:
                onClickListener.onClickDelete(getAdapterPosition());
                break;
        }
    }
}
