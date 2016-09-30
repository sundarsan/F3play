package com.mirafra.video.network;

import com.mirafra.video.utils.VideosModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sumitkumar on 29/09/16.
 */

public interface WebServices {

    @GET("video-index.json")
    Call<VideosModel> getVideos();

}
