package com.example.homecookBackend.classes;

public class ReturnImg {

    public String name;
    public String type;
    public int out;
    public String path;


    public ReturnImg(String name, String type, int out, String path) {
        this.name = name;
        this.type = type;
        this.out = out;
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
