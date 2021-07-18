package com.myfirst.itunesapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private RecyclerView mRecyclerView;
    private ResponseItunes responseItunes;
    private EditText mEtTitle;
    private Button mBtnSearch;
    private MediaPlayer player;
    ItunesAdapter itunesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mEtTitle = findViewById(R.id.etTitle);
        mBtnSearch = findViewById(R.id.btnSearch);
        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiServices apiServices = Network.getInstance().create(ApiServices.class);
        String term = mEtTitle.getText().toString();
        apiServices.getPosts(term).enqueue(new Callback<ResponseItunes>() {
            @Override
            public void onResponse(Call<ResponseItunes> call, Response<ResponseItunes> response) {
                responseItunes = response.body();
                setRecyclerView();
            }

            @Override
            public void onFailure(Call<ResponseItunes> call, Throwable t) {

            }
        });
    }

    public void setRecyclerView() {
        itunesAdapter = new ItunesAdapter(responseItunes.getResults(), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setAdapter(itunesAdapter);
        mRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void onClickPlay(int position) {
        if(player != null){
            player.pause();
            player.stop();
            player.release();
        }
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource(responseItunes.getResults().get(position).getPreviewUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player.start();
    }

    @Override
    public void onClickPause(int position) {
        if (player != null) {
            player.pause();
            player.stop();
            player.release();
            player = null;
        }
    }

    @Override
    public void onClickDelete(int position) {
        responseItunes.getResults().remove(position);
        itunesAdapter.notifyDataSetChanged();
    }
}