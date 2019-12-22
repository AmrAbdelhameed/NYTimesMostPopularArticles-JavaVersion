package com.example.learningapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticlesResponse {

    @SerializedName("results")
    public List<Article> articles;
    private String status;
    private String copyright;
    private int num_results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public static class Article implements Parcelable {

        public static final Creator<Article> CREATOR = new Creator<Article>() {
            @Override
            public Article createFromParcel(Parcel in) {
                return new Article(in);
            }

            @Override
            public Article[] newArray(int size) {
                return new Article[size];
            }
        };
        private String url;
        private String section;
        private String byline;
        private String type;
        private String title;
        @SerializedName("abstract")
        private String abstractX;
        private String published_date;
        private String source;
        private String uri;
        private List<MediaBean> media;

        protected Article(Parcel in) {
            url = in.readString();
            section = in.readString();
            byline = in.readString();
            type = in.readString();
            title = in.readString();
            abstractX = in.readString();
            published_date = in.readString();
            source = in.readString();
            uri = in.readString();
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public String getPublished_date() {
            return published_date;
        }

        public void setPublished_date(String published_date) {
            this.published_date = published_date;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public List<MediaBean> getMedia() {
            return media;
        }

        public void setMedia(List<MediaBean> media) {
            this.media = media;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(url);
            parcel.writeString(section);
            parcel.writeString(byline);
            parcel.writeString(type);
            parcel.writeString(title);
            parcel.writeString(abstractX);
            parcel.writeString(published_date);
            parcel.writeString(source);
            parcel.writeString(uri);
        }

        public static class MediaBean {

            @SerializedName("media-metadata")
            private List<MediametadataBean> mediametadata;

            public List<MediametadataBean> getMediametadata() {
                return mediametadata;
            }

            public void setMediametadata(List<MediametadataBean> mediametadata) {
                this.mediametadata = mediametadata;
            }

            public static class MediametadataBean {

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
