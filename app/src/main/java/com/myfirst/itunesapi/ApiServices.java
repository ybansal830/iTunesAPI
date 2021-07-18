package com.myfirst.itunesapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServices {

    @GET("/search")
    Call<ResponseItunes> getPosts(@Query("term") String term);

}
