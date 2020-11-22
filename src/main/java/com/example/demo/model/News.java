package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "featured",
        "title",
        "url",
        "imageUrl",
        "newsSite",
        "summary",
        "publishedAt",
        "launches",
        "events"
})
public class News {

    private Long news_id;

    @JsonProperty("id")
    private transient String id;

    @JsonProperty("featured")
    private transient Boolean featured;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private transient String url;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("newsSite")
    private transient String newsSite;

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("publishedAt")
    private transient String publishedAt;

    @JsonProperty("launches")
    private transient List<Launch> launches = null;

    @JsonProperty("events")
    private transient List<Event> events = null;

    public Long getNews_id() {
        return news_id;
    }

    public void setNews_id(Long news_id) {
        this.news_id = news_id;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("featured")
    public Boolean getFeatured() {
        return featured;
    }

    @JsonProperty("featured")
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("newsSite")
    public String getNewsSite() {
        return newsSite;
    }

    @JsonProperty("newsSite")
    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("launches")
    public List<Launch> getLaunches() {
        return launches;
    }

    @JsonProperty("launches")
    public void setLaunches(List<Launch> launches) {
        this.launches = launches;
    }

    @JsonProperty("events")
    public List<Event> getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
