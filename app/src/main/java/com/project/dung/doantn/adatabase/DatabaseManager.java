package com.project.dung.doantn.adatabase;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by Dung on 4/15/2017.
 */

public class DatabaseManager {
    private static final String DB_NAME = "sensor";
    private static final String TB_DATA = "tb_data";
    private static final String TB_SENSOR = "tb_sensor";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        OpenHelper openHelper = new OpenHelper(context);
        database = openHelper.getWritableDatabase();


    }

    public class OpenHelper extends SQLiteOpenHelper {

        public OpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        /**
         * create table
         *
         * @param sqLiteDatabase
         */
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String tb_data = "CREATE TABLE IF NOT EXISTS tb_data(Id TEXT PRIMARY KEY , Data FLOAT, Time1 TEXT,Date1 TEXT )";
            sqLiteDatabase.execSQL(tb_data);
            String tb_sensor = "CREATE TABLE IF NOT EXISTS tb_sensor(Id TEXT PRIMARY KEY , Name TEXT, Serial TEXT, Latitude TEXT, " +
                    "Longitude TEXT,Bottomthreshold TEXT, Topthreshold TEXT,Type TEXT,Status TEXT)";
            sqLiteDatabase.execSQL(tb_sensor);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TB_DATA);
            sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + TB_SENSOR);
            onCreate(sqLiteDatabase);


        }

    }
    public void insertData(String Id , Float value, String time, String date) {
        ContentValues values = new ContentValues();
        values.put("Id", Id);
        values.put("Data", value);
        values.put("Time1", time);
        values.put("Date1", date);
        database.insertOrThrow(TB_DATA, null, values);
        database.close();
    }
    public float[] getDataSensor(){
        float[] arry = new float[countData()];
        int i=0;
        Cursor cursor =database.query(TB_DATA, new String[]{"Data"}, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
           do {
               arry[i] = cursor.getFloat(0);
               i++;

               }while (cursor.moveToNext());

        }
        return arry;
    }
    public String[] getLable(){
        String[] arry = new String[countData()];
        int i=0;
        Cursor cursor =database.query(TB_DATA, new String[]{ "Date1"}, null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                arry[i] = cursor.getString(0);
                i++;

            }while (cursor.moveToNext());

        }
        return arry;
    }
    public int countData(){
        Cursor mCount= database.rawQuery("select count(*) from "+TB_DATA, null);
        mCount.moveToFirst();
        int count= mCount.getInt(0);
        mCount.close();
        return  count;
    }



}
