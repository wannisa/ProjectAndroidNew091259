package com.example.mrbennerham.calendar;



public class FeedItem {
    private String ID;
    private String Title;
    private String Detail;

    //GETTER
    public String getID() {
        return ID;
    }
    public String getTitle() {
        return Title;
    }
    public String getDetail() {
        return Detail;
    }

    //SETTER
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }
}