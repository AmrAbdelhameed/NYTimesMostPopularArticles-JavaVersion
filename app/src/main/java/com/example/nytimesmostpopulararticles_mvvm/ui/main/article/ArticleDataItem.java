package com.example.nytimesmostpopulararticles_mvvm.ui.main.article;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticleDataItem implements Parcelable {
    private long id;
    private String imageUrl;
    private String title;
    private String byline;
    private String abstractX;
    private String publishedDate;
    private String url;
    private String coverImageUrl;

    public ArticleDataItem(long id, String imageUrl, String title, String byline, String abstractX, String publishedDate, String url, String coverImageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.byline = byline;
        this.abstractX = abstractX;
        this.publishedDate = publishedDate;
        this.url = url;
        this.coverImageUrl = coverImageUrl;
    }

    protected ArticleDataItem(Parcel in) {
        id = in.readLong();
        imageUrl = in.readString();
        title = in.readString();
        byline = in.readString();
        abstractX = in.readString();
        publishedDate = in.readString();
        url = in.readString();
        coverImageUrl = in.readString();
    }

    public static final Creator<ArticleDataItem> CREATOR = new Creator<ArticleDataItem>() {
        @Override
        public ArticleDataItem createFromParcel(Parcel in) {
            return new ArticleDataItem(in);
        }

        @Override
        public ArticleDataItem[] newArray(int size) {
            return new ArticleDataItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(imageUrl);
        dest.writeString(title);
        dest.writeString(byline);
        dest.writeString(abstractX);
        dest.writeString(publishedDate);
        dest.writeString(url);
        dest.writeString(coverImageUrl);
    }

    public long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getByline() {
        return byline;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getUrl() {
        return url;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }
}
