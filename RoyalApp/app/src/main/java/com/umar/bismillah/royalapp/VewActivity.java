package com.umar.bismillah.royalapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VewActivity extends AppCompatActivity implements OnClickListener {
    SQLiteDatabase db;
    Button btnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vew);

        btnview=(Button)findViewById(R.id.btnview);

        btnview.setOnClickListener(this);
        db = openOrCreateDatabase("MyDABS", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(country VARCHAR,rooms VARCHAR,name VARCHAR,cnic VARCHAR,address VARCHAR,Cell VARCHAR,email VARCHAR);");

    }

    @Override
    public void onClick(View view) {

        if (view == btnview) {
            Cursor c = db.rawQuery("SELECT * FROM user", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuffer buffer = new StringBuffer();
            while (c.moveToNext()) {
                buffer.append("country: " + c.getString(0) + "\n");
                buffer.append("rooms: " + c.getString(1) + "\n");
                buffer.append("name: " + c.getString(2) + "\n");
                buffer.append("cnic: " + c.getString(3) + "\n");
                buffer.append("address: " + c.getString(4) + "\n");
                buffer.append("cell: " + c.getString(5) + "\n");
                buffer.append("email: " + c.getString(6) + "\n ,\n");
            }
            showMessage("User Details", buffer.toString());

        }
    }

    private void showMessage(String title, String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();


    }

}
