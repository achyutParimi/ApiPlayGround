package com.apiplayground.model;
import java.util.List;

public class ResponseData {
    private String title;
    private Object err; // Use Object for "null" values

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getErr() {
        return err;
    }

    public void setErr(Object err) {
        this.err = err;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(List<RealEstateRecord> data) {
        this.data = data;
    }

    private int count;
    private List<RealEstateRecord> data;

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public List<RealEstateRecord> getData() {
        return data;
    }

    // Getters and setters
}
