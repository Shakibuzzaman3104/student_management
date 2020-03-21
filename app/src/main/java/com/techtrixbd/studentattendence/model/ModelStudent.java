package com.techtrixbd.studentattendence.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelStudent {
    @SerializedName("student_id")
    @Expose
    private String studentId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("section")
    @Expose
    private String section;


    public ModelStudent(String studentId, String name, String email, String section) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.section = section;
    }

    public ModelStudent() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
