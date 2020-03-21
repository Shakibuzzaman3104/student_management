package com.techtrixbd.studentattendence.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAttendence {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("st_id")
    @Expose
    private String stId;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;

    public ModelAttendence(String stId, String date, String time) {
        this.stId = stId;
        this.date = date;
        this.time = time;
    }

    public ModelAttendence() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
