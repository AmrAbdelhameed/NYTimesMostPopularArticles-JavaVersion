package com.example.nytimesmostpopulararticles_mvvm.data.model.api;

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

    public static class Article {
        private long id;
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

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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
