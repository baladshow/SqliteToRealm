package com.jixa.converter;


import android.content.Context;
import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class RealmHelper {
    private static  Context mContext;
    private static RealmHelper mInstance;
    private RealmList<Word> words;
    public static RealmHelper createInstance(Context context){
        return mInstance  = new RealmHelper(context);
    }
    public static RealmHelper getIntance(){
        return mInstance;
    }
    private RealmHelper(Context context){
        mContext = context;
    }

    public void loadWords(List<Word> allWords){
//        this.words =
        Log.d("8888888888",mContext.toString());
        Realm.deleteRealmFile(mContext);
        Realm realm = Realm.getInstance(mContext);
//        words = new RealmList<>();
        realm.beginTransaction();
//        for (Word word : allWords){
//            words.add(realm.copyToRealm())
//        }
        realm.copyToRealm(allWords);
        realm.commitTransaction();

    }
    public void addSynonymToWords(List<IntPair> synonyms){
        Realm realm = Realm.getInstance(mContext);
        realm.beginTransaction();
        for(IntPair pair : synonyms){
            if(pair.getFirstVal() > 5000 || pair.getSocondVal() > 5000)
                continue;
            RealmList<Word> wordSynonyms =  realm.where(Word.class).equalTo("id",pair.getFirstVal()).findFirst().getSynonyms();
            Log.d("8888888888888",pair.toString());
            wordSynonyms.add(realm.where(Word.class).equalTo("id",pair.getSocondVal()).findFirst());
        }
        realm.commitTransaction();
    }

    public Word getWord(int id){
        Realm realm = Realm.getInstance(mContext);
        return realm.where(Word.class).equalTo("id",id).findFirst();
    }
}
