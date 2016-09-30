package com.mirafra.video.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mirafra.video.R;
import com.mirafra.video.network.WebServices;
import com.mirafra.video.utils.RecyclerItemClickListener;
import com.mirafra.video.utils.VideosListAdapter;
import com.mirafra.video.utils.VideosModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideosList extends AppCompatActivity {

    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://www.f3software.com/static-api/")
            .build();

    WebServices api = retrofit.create(WebServices.class);

    RecyclerView videos;
    VideosListAdapter adapter;
    List<VideosModel.Results.Video> videoList = new ArrayList<>();
    ProgressDialog dialog;
    private boolean isFetching = true;

    @Override
    protected void onResume() {
        super.onResume();
        if(dialog != null && isFetching)
            dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos_list);

        videos = (RecyclerView) findViewById(R.id.activity_videos_list);

        videos.setHasFixedSize(true);
        videos.setLayoutManager(new LinearLayoutManager(this));
        videos.getItemAnimator().setChangeDuration(0);
        videos.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), VideoDetail.class);
                intent.putExtra("DATA", videoList.get(position));
                startActivity(intent);
            }
        }));

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setIndeterminate(true);
        dialog.setMessage("Fetching data...");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        api.getVideos().enqueue(new Callback<VideosModel>() {
            @Override
            public void onResponse(Call<VideosModel> call, Response<VideosModel> response) {
                if(dialog != null)
                    dialog.dismiss();
                isFetching = false;
                VideosModel.Results results = response.body().getResults();
                videoList = new ArrayList<>(results.getVideo().values());
                adapter = new VideosListAdapter(getApplicationContext(), videoList);
                videos.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<VideosModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(dialog != null)
            dialog.dismiss();
    }
}