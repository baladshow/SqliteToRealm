package com.jixa.converter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class SqliteHelper extends SQLiteOpenHelper
{
    private static String TAG = "DataBaseHelper";
    private static String DB_PATH = "";
    private static String DB_NAME ="all.db";
    private SQLiteDatabase mDataBase;
    private static Context mContext;
    private static SqliteHelper mInstance;

    public static SqliteHelper createInstance(Context context){
        return mInstance = new SqliteHelper(context);
    }
    public static SqliteHelper getInstance(){
        return mInstance;
    }

    private SqliteHelper(Context context)
    {
        super(context, DB_NAME, null, 1);// 1? its Database Version
        mContext = context;
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() throws IOException
    {

        boolean mDataBaseExist = checkDataBase();
        if(!mDataBaseExist)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            }
            catch (IOException mIOException)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    private boolean checkDataBase()
    {
//        return false;
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException
    {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0)
        {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException
    {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);

        return mDataBase != null;
    }

    public List<List<String>> getRecords(String tableName){
        SQLiteDatabase reader = getReadableDatabase();
        Cursor cursor = reader.rawQuery("SELECT * FROM " + tableName,null);
        cursor.moveToFirst();
        List<List<String>> records = new ArrayList<>();
        int t =0;
        do {
            Log.d("888888888", String.valueOf( t++));
            if(t>5000)
                break;
            List<String> record = new ArrayList<>();
            for(int i =0 ; i<cursor.getColumnCount();i++){
                String field = cursor.getString(i);
                if(null != field) {
                    record.add(field);

                }
                else
                    record.add("this is null");

            }
            records.add(record);
//            Log.d(TAG,cursor.getString(0));

        }while(cursor.moveToNext());
        return records;
    }


//
//    public List<String> readWords(){
//        Realm realm = Realm.getInstance(mContext);
//        Cursor cursor = reader.rawQuery("SELECT * FROM TOFEL",null);
//        cursor.moveToFirst();
//        realm.beginTransaction();
//        do {
//            TestWord word = realm.createObject(TestWord.class);
//            word.setId(Integer.parseInt(cursor.getString(0)));
//            word.setWord(cursor.getString(1));
////            Log.d(TAG,cursor.getString(0));
//
//        }while(cursor.moveToNext());
//        realm.commitTransaction();
//        return null;
//    }
//
//    public RealmResults<TestWord> getWord(int id){
//        Realm realm = Realm.getInstance(mContext);
//        return realm.where(TestWord.class).equalTo("id",id).findAll();
//    }

    @Override
    public synchronized void close()
    {
        if(mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}