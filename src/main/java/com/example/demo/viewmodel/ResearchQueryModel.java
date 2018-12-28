package com.example.demo.viewmodel;

import com.example.demo.common.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ResearchQueryModel {

    private String title;
    private int page;
    private int size;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Page getPageModel(){
        return new Page(this.page,this.size);
    }
}
