package com.jixa.converter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;

public class SqliteToRealm {
    private static SqliteToRealm mInstance;
    private static Context mContext;

    public static SqliteToRealm createInstance(Context context){
        return mInstance = new SqliteToRealm(context);
    }
    public static SqliteToRealm getInstance() {
        return mInstance;
    }

    private SqliteToRealm(Context context) {
        this.mContext =context;
    }

    public List<Word> getAllRawWords(){
        List<List<String>> records = SqliteHelper.getInstance().getRecords("word");
        List<Word> words = new ArrayList<>();
        for(List<String> record : records){
            Word word = new Word();
            word.setId(Integer.parseInt(record.get(0)));
            word.setFavorite(false);
            word.setText(record.get(1));
            word.setDefinition(record.get(2));
//            word.setImage(record.get(2));
            word.setLevel(Integer.parseInt(record.get(5)));
            words.add(word);
        }
        return words;
    }

    public void pushSynonymsToWords(){
        SqliteHelper dbs = SqliteHelper.getInstance();
        RealmHelper dbr = RealmHelper.getIntance();
        List<Word> rawWords = getAllRawWords();
        List<List<String>> records = dbs.getRecords("synonym");
        List<IntPair> synonyms = new ArrayList<>();
        for(List<String> record : records){
            if(null == record.get(0) || null == record.get(1))
                continue;
            IntPair pair = new IntPair(Integer.parseInt(record.get(0)),Integer.parseInt(record.get(1)));
            synonyms.add(pair);
        }
        dbr.addSynonymToWords(synonyms);
    }

    public void SqliteToRealm(){
//        SqliteHelper dbs = SqliteHelper.getInstance();
        RealmHelper dbr = RealmHelper.getIntance();
        List words = getAllRawWords();
        dbr.loadWords(words);
        pushSynonymsToWords();

    }



}
