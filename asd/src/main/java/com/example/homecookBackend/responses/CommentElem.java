package com.example.homecookBackend.responses;

import com.example.homecookBackend.classes.client.Client;

import java.util.Date;

public class CommentElem {
    private int id;

    private String client_name;

    private float score;

    private java.util.Date date;

    private String comment;

    public CommentElem(int id, String client_name, float score, java.util.Date date, String comment){
        this.id = id;
        this.client_name =client_name;
        this.score = score;
        this.date = date;
        this.comment = comment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
