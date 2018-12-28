package com.example.demo.common;

import org.apache.ibatis.session.RowBounds;

public class Page {
    private int page;
    private int size;

    public Page(int page,int size){
        this.page=page;
        this.size=size;
    }

    public RowBounds getRowBounds(){
        return new RowBounds((this.page-1)*this.size,this.size);
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
}
