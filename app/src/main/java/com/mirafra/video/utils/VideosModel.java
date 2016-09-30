package com.mirafra.video.utils;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by sumitkumar on 29/09/16.
 */

public class VideosModel implements Serializable{

    @SerializedName("assets")
    private Results results;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public class Results implements Serializable {
        @SerializedName("video")
        private Map<String, Video> video;

        public Map<String, Video> getVideo() {
            return video;
        }

        public void setVideo(Map<String, Video> video) {
            this.video = video;
        }

        public class Video implements Serializable {

            @SerializedName("id")
            private int id;

            @SerializedName("language")
            private String language;

            @SerializedName("title")
            private String title;

            @SerializedName("description")
            private String description;

            @SerializedName("list_order")
            private int listOrder;

            @SerializedName("length")
            private String length;

            @SerializedName("image_url")
            private String imageURL;

            @SerializedName("preview_url")
            private String previewURL;

            @SerializedName("video_url")
            private String videoURL;

            @SerializedName("streaming_url")
            private String streamingURL;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getListOrder() {
                return listOrder;
            }

            public void setListOrder(int listOrder) {
                this.listOrder = listOrder;
            }

            public String getLength() {
                return length;
            }

            public void setLength(String length) {
                this.length = length;
            }

            public String getImageURL() {
                return imageURL;
            }

            public void setImageURL(String imageURL) {
                this.imageURL = imageURL;
            }

            public String getPreviewURL() {
                return previewURL;
            }

            public void setPreviewURL(String previewURL) {
                this.previewURL = previewURL;
            }

            public String getVideoURL() {
                return videoURL;
            }

            public void setVideoURL(String videoURL) {
                this.videoURL = videoURL;
            }

            public String getStreamingURL() {
                return streamingURL;
            }

            public void setStreamingURL(String streamingURL) {
                this.streamingURL = streamingURL;
            }
        }
    }
}
