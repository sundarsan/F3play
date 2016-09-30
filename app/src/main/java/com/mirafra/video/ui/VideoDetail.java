package com.mirafra.video.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirafra.video.R;
import com.mirafra.video.utils.VideosModel;
import com.squareup.picasso.Picasso;

public class VideoDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        final VideosModel.Results.Video video = (VideosModel.Results.Video) getIntent().getSerializableExtra("DATA");

        ImageView poster = (ImageView) findViewById(R.id.poster);
        TextView title = (TextView) findViewById(R.id.title);
        TextView description = (TextView) findViewById(R.id.description);
        TextView duration = (TextView) findViewById(R.id.duration);

        FloatingActionButton play = (FloatingActionButton) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDetail.this, PlayVideo.class);
                intent.putExtra("URL", video.getStreamingURL());
                startActivity(intent);
            }
        });

        Picasso.with(this).load(video.getImageURL()).into(poster);
        String titleStr = video.getTitle();
        if(titleStr != null && titleStr.length() > 0)
            title.setText(video.getTitle());
        else
            title.setText(R.string.title_error);

        String descStr = video.getDescription();
        if(descStr != null && descStr.length() > 0)
            description.setText(video.getDescription());
        else
            description.setText(R.string.desc_error);

        if(video.getLength() != null && video.getLength().length() > 0)
            duration.setText("Duration " + video.getLength() + " min");
        else
            duration.setText("Duration 00:00 min");
    }
}
