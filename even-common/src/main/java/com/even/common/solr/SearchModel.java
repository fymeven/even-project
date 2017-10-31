package com.even.common.solr;

import java.io.Serializable;

/**
 * Created by fymeven on 2017/7/10.
 */
public class SearchModel implements Serializable{
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int id;
    private String title;
    private String text;
}
