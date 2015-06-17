package com.jixa.converter;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Word extends RealmObject {

    @PrimaryKey
    private int id;

    private String text;

    private String definition;

    private RealmList<Word> synonyms;

    private RealmList<Word> antonyms;

    private RealmList<Sentence> sentences;

    private String image;

    private int level;

    private boolean isFavorite;

    public Word() {
    }

    public Word(String word) {
        this.text = word;
    }

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

    public RealmList<Word> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(RealmList<Word> synonyms) {
        this.synonyms = synonyms;
    }

    public RealmList<Word> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(RealmList<Word> antonyms) {
        this.antonyms = antonyms;
    }

    public RealmList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(RealmList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
