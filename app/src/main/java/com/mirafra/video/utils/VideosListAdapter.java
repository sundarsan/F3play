package com.mirafra.video.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirafra.video.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sumitkumar on 30/09/16.
 */

public class VideosListAdapter extends RecyclerView.Adapter<VideosListAdapter.VideosHolder> {

    private Context context;
    private List<VideosModel.Results.Video> videos;
    private LayoutInflater inflater;

    public VideosListAdapter(Context context, List<VideosModel.Results.Video> videos) {
        super();
        this.context = context;
        this.videos = videos;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public VideosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new VideosHolder(view);
    }

    @Override
    public void onBindViewHolder(VideosHolder holder, int position) {
        holder.name.setText(videos.get(position).getTitle());
        Picasso.with(context).load(videos.get(position).getImageURL()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    class VideosHolder extends RecyclerView.ViewHolder {

        ImageView thumbnail;
        TextView name;

        public VideosHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}