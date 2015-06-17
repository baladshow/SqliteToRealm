package com.jixa.converter;


import java.util.Date;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ReviewableWord extends RealmObject{

    @PrimaryKey
    private int id;

    private Word word;

    private long nextReview;

    private int stage;

    public ReviewableWord (){}

    public ReviewableWord(Word word){
        this.setWord(word);
        this.setNextReview(nextReview);
        this.stage = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public long getNextReview() {
        return nextReview;
    }

    public void setNextReview(long nextReview) {
        this.nextReview = nextReview;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

}
