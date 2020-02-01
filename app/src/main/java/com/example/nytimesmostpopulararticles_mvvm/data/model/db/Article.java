package com.example.nytimesmostpopulararticles_mvvm.data.model.db;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class Article implements Parcelable {
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
    @PrimaryKey
    private long id;
    @ColumnInfo(name = "image_url")
    private String imageUrl;
    private String title;
    private String byline;
    @ColumnInfo(name = "abstract")
    private String abstractX;
    @ColumnInfo(name = "published_date")
    private String publishedDate;
    private String url;
    @ColumnInfo(name = "cover_image_url")
    private String coverImageUrl;

    public Article(long id, String imageUrl, String title, String byline, String abstractX, String publishedDate, String url, String coverImageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.byline = byline;
        this.abstractX = abstractX;
        this.publishedDate = publishedDate;
        this.url = url;
        this.coverImageUrl = coverImageUrl;
    }

    protected Article(Parcel in) {
        id = in.readLong();
        imageUrl = in.readString();
        title = in.readString();
        byline = in.readString();
        abstractX = in.readString();
        publishedDate = in.readString();
        url = in.readString();
        coverImageUrl = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(imageUrl);
        parcel.writeString(title);
        parcel.writeString(byline);
        parcel.writeString(abstractX);
        parcel.writeString(publishedDate);
        parcel.writeString(url);
        parcel.writeString(coverImageUrl);
    }
}
