package com.udinus.kamis_10210_nurularifin_tugassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "data_mhs.db";
    public static final String TABLE_NAME = "table_mhs";
    public static final String COL_1 = "nim";
    public static final String COL_2 = "nama";
    public static final String COL_3 = "tglLahir";
    public static final String COL_4 = "jk";
    public static final String COL_5 = "alamat";
    public static final String COL_6 = "kota";
    public  static final int DB_VERSION = 1;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE table_mhs(nim TEXT NOT NULL UNIQUE, nama TEXT NOT NULL, tglLahir TEXT NOT NULL, jk TEXT NOT NULL, alamat TEXT NOT NULL, kota TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String nim, String nama, String tglLahir, String jk, String alamat, String kota){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nim);
        contentValues.put(COL_2, nama);
        contentValues.put(COL_3, tglLahir);
        contentValues.put(COL_4, jk);
        contentValues.put(COL_5, alamat);
        contentValues.put(COL_6, kota);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM table_mhs", null);
        return result;
    }

    public List<MahasiswaModel> getAllDataToArray(){
        List<MahasiswaModel> mahasiswaModelList = new ArrayList<>();
        String query = "SELECT * FROM table_mhs";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery(query, null);
        if (result.moveToFirst()){
            do {
                mahasiswaModelList.add(new MahasiswaModel(result.getString(0), result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5)));
            }while (result.moveToNext());
        }
        return mahasiswaModelList;
    }

}
