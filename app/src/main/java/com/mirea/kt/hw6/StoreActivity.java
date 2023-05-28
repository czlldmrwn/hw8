package com.mirea.kt.hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {
    private SQLiteOpenHelper sqLiteHelper;

    public ArrayList<Store> loadAllStoresFromDatabase() {
        ArrayList<Store> stores = new ArrayList<>();
        SQLiteDatabase db = this.sqLiteHelper.getWritableDatabase();
        Cursor dbCursor = db.query("TABLE_STORES", null, null,
                null, null, null, null);
        if (dbCursor.moveToFirst()) {
            do {
                String name = dbCursor.getString((dbCursor.getColumnIndexOrThrow("name")));
                String address = dbCursor.getString((dbCursor.getColumnIndexOrThrow("address")));
                int hoursOpen = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("hoursOpen"));
                int hoursClose = dbCursor.getInt(dbCursor.getColumnIndexOrThrow("hoursClose"));
                stores.add(new Store(name, address, hoursOpen, hoursClose));
            } while (dbCursor.moveToNext());
        }
        dbCursor.close();
        db.close();
        return stores;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        RecyclerView rcView = findViewById(R.id.recyclerView);
        ArrayList<Store> stores = loadAllStoresFromDatabase();
        StoreAdapter adapter = new StoreAdapter(stores);
        rcView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rcView.setAdapter(adapter);
    }
}