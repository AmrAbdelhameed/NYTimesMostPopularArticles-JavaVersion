package com.example.learningapp.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
    @SerializedName("abstract")
    private String mAbstract;
    @SerializedName("adx_keywords")
    private String mAdxKeywords;
    @SerializedName("asset_id")
    private Long mAssetId;
    @SerializedName("byline")
    private String mByline;
    @SerializedName("column")
    private Object mColumn;
    @SerializedName("des_facet")
    private Object mDesFacet;
    @SerializedName("geo_facet")
    private Object mGeoFacet;
    @SerializedName("id")
    private Long mId;
    @SerializedName("media")
    private List<Medium> mMedia;
    @SerializedName("org_facet")
    private Object mOrgFacet;
    @SerializedName("per_facet")
    private Object mPerFacet;
    @SerializedName("published_date")
    private String mPublishedDate;
    @SerializedName("section")
    private String mSection;
    @SerializedName("source")
    private String mSource;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("views")
    private Long mViews;

    protected Article(Parcel in) {
        mAbstract = in.readString();
        mAdxKeywords = in.readString();
        if (in.readByte() == 0) {
            mAssetId = null;
        } else {
            mAssetId = in.readLong();
        }
        mByline = in.readString();
        if (in.readByte() == 0) {
            mId = null;
        } else {
            mId = in.readLong();
        }
        mMedia = in.createTypedArrayList(Medium.CREATOR);
        mPublishedDate = in.readString();
        mSection = in.readString();
        mSource = in.readString();
        mTitle = in.readString();
        mType = in.readString();
        mUrl = in.readString();
        if (in.readByte() == 0) {
            mViews = null;
        } else {
            mViews = in.readLong();
        }
    }

    public String getAbstract() {
        return mAbstract;
    }

    public void setAbstract(String mAbstract) {
        this.mAbstract = mAbstract;
    }

    public String getAdxKeywords() {
        return mAdxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        mAdxKeywords = adxKeywords;
    }

    public Long getAssetId() {
        return mAssetId;
    }

    public void setAssetId(Long assetId) {
        mAssetId = assetId;
    }

    public String getByline() {
        return mByline;
    }

    public void setByline(String byline) {
        mByline = byline;
    }

    public Object getColumn() {
        return mColumn;
    }

    public void setColumn(Object column) {
        mColumn = column;
    }

    public Object getDesFacet() {
        return mDesFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        mDesFacet = desFacet;
    }

    public Object getGeoFacet() {
        return mGeoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        mGeoFacet = geoFacet;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<Medium> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Medium> media) {
        mMedia = media;
    }

    public Object getOrgFacet() {
        return mOrgFacet;
    }

    public void setOrgFacet(String orgFacet) {
        mOrgFacet = orgFacet;
    }

    public Object getPerFacet() {
        return mPerFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        mPerFacet = perFacet;
    }

    public String getPublishedDate() {
        return mPublishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        mPublishedDate = publishedDate;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Long getViews() {
        return mViews;
    }

    public void setViews(Long views) {
        mViews = views;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mAbstract);
        parcel.writeString(mAdxKeywords);
        if (mAssetId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(mAssetId);
        }
        parcel.writeString(mByline);
        if (mId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(mId);
        }
        parcel.writeTypedList(mMedia);
        parcel.writeString(mPublishedDate);
        parcel.writeString(mSection);
        parcel.writeString(mSource);
        parcel.writeString(mTitle);
        parcel.writeString(mType);
        parcel.writeString(mUrl);
        if (mViews == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(mViews);
        }
    }
}
