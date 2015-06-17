package com.jixa.converter;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Course extends RealmObject{

    @PrimaryKey
    private int  id;

    private String name;

    private int numStageRequired;

    private int numNewWordPerDay;

    private int CourseType;

    private RealmList<ReviewableWord> reviewableWords;

    private RealmList<ReviewableWord> needMoreReview;

    public Course(){   }

    public Course(int numNewWordPerDay, int numWordLimitPerDay){
        this.numNewWordPerDay = numNewWordPerDay;
        this.numStageRequired = 5;
    }

    public Course(int numNewWordPerDay, int numWordLimitPerDay, int numStageRequired){
        this.numNewWordPerDay = numNewWordPerDay;
        this.numStageRequired = numStageRequired;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumStageRequired() {
        return numStageRequired;
    }

    public void setNumStageRequired(int numStageRequired) {
        this.numStageRequired = numStageRequired;
    }

    public int getNumNewWordPerDay() {
        return numNewWordPerDay;
    }

    public void setNumNewWordPerDay(int numNewWordPerDay) {
        this.numNewWordPerDay = numNewWordPerDay;
    }

    public RealmList<ReviewableWord> getReviewableWords() {
        return reviewableWords;
    }

    public void setReviewableWords(RealmList<ReviewableWord> reviewableWords) {
        this.reviewableWords = reviewableWords;
    }

    public RealmList<ReviewableWord> getNeedMoreReview() {
        return needMoreReview;
    }

    public void setNeedMoreReview(RealmList<ReviewableWord> needMoreReview) {
        this.needMoreReview = needMoreReview;
    }

    public int getCourseType() {
        return CourseType;
    }

    public void setCourseType(int courseType) {
        CourseType = courseType;
    }
}
