package com.mirea.kt.hw6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBManager {
    private SQLiteOpenHelper sqLiteHelper;

    public DBManager(SQLiteOpenHelper sqLiteHelper) {
        this.sqLiteHelper = sqLiteHelper;
    }

    public boolean saveStoreToDatabase(Store store){
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", store.getName());
        cv.put("address", store.getAddress());
        cv.put("hours_open", store.getHoursOpen());
        cv.put("hours_close", store.getHoursClose());
        long rowId = db.insert("TABLE_STORES", null, cv);
        cv.clear();
        db.close();
        return rowId != -1;
    }

}
