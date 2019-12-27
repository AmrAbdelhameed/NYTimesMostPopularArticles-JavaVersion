package com.example.nytimesmostpopulararticles_mvvm.data.model.others;

public class ArticleDetails {
    private final String imageUrl;
    private final String title;
    private final String author;
    private final String content;
    private final String date;
    private final String url;

    public ArticleDetails(String imageUrl, String title, String author, String content, String date, String url) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
