package com.jixa.converter;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TestWord extends RealmObject{

    @PrimaryKey
    private int id;

    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
