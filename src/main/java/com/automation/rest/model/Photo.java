package com.automation.rest.model;

/**
 * Created by Serhii Starovoit on 2/1/2017.
 */
public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo()  {
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (albumId != photo.albumId) return false;
        if (id != photo.id) return false;
        if (title != null ? !title.equals(photo.title) : photo.title != null) return false;
        if (url != null ? !url.equals(photo.url) : photo.url != null) return false;
        return thumbnailUrl != null ? thumbnailUrl.equals(photo.thumbnailUrl) : photo.thumbnailUrl == null;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }


}
