package com.mirea.kt.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName, editTextAddress, editTextHoursOpen, editTextHoursClose;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.dbManager = new DBManager(new MyAppSQLiteHelper(this, "stores_database.db",
                null, 1));
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.etName);
        editTextAddress = findViewById(R.id.etAddress);
        editTextHoursOpen = findViewById(R.id.etHoursOpen);
        editTextHoursClose = findViewById(R.id.etHoursClose);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnNext = findViewById(R.id.btnNext);
        btnAdd.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btnAdd){
            if (this.dbManager != null){
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String hoursOpen = editTextHoursOpen.getText().toString();
                String hoursClose = editTextHoursClose.getText().toString();
                if (!name.isEmpty() && !address.isEmpty() && !hoursOpen.isEmpty() && hoursClose.isEmpty()) {
                    boolean result = dbManager.saveStoreToDatabase(new Store(name, address, Integer.parseInt(hoursOpen), Integer.parseInt(hoursClose)));
                    if (result) {
                        Toast.makeText(this, R.string.insert_success, Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(this, R.string.insert_error, Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(this, R.string.incorrect_value, Toast.LENGTH_LONG).show();
                }
            }
        } else if (v.getId() == R.id.btnNext) {
            startActivity(new Intent(this, StoreActivity.class));
        }
    }
}