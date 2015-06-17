package com.jixa.converter;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Exam extends RealmObject {

    @PrimaryKey
    private int id;

    private String name;

    private String description;

    private RealmList<Collection> collections;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RealmList<Collection> getCollections() {
        return collections;
    }

    public void setCollections(RealmList<Collection> collections) {
        this.collections = collections;
    }
}
