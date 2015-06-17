package com.jixa.converter;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Sentence extends RealmObject {

    @PrimaryKey
    private int id;

    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
