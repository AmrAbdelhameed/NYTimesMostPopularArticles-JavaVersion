package com.example.nytimesmostpopulararticles_mvvm.data.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
public class Article {
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
