package com.umar.bismillah.royalapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import static android.R.id.edit;

public class BookingActivity  extends AppCompatActivity implements OnClickListener {

        Spinner spinner, spinner2;
        Button btnSub, btnAdm;
        EditText country,rooms,pasp,name,email,phone,address;
        SQLiteDatabase db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_booking);

            country= (EditText) findViewById(R.id.editCountry);
            rooms = (EditText) findViewById(R.id.editRooms);
            name= (EditText) findViewById(R.id.editName);
            pasp = (EditText) findViewById(R.id.editPassp);
            address = (EditText) findViewById(R.id.editAdress);
            phone = (EditText) findViewById(R.id.editPhone);
            email= (EditText) findViewById(R.id.editEmail);

            btnSub = (Button) findViewById(R.id.btnSub);

            btnAdm= (Button) findViewById(R.id.btnAdm);

            btnAdm.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent next = new Intent(BookingActivity.this,LoginActivity.class);
                    startActivity(next);
                }
            });


            btnSub.setOnClickListener((View.OnClickListener) this);

            db = openOrCreateDatabase("MyDBS", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS user(country VARCHAR,rooms VARCHAR,name VARCHAR,cnic VARCHAR,address VARCHAR,Cell VARCHAR,email VARCHAR);");


        }

        @Override
        public void onClick(View view) {
            if (view == btnSub) {
                if (
                       country.getText().toString().trim().length() == 0 ||
                        rooms.getText().toString().trim().length() == 0 ||
                        name.getText().toString().trim().length() == 0 ||
                        pasp.getText().toString().trim().length() == 0 ||
                        address.getText().toString().trim().length() == 0 ||
                        phone.getText().toString().trim().length() == 0 ||
                        email.getText().toString().trim().length() == 0




                        ) {

                    showMessage("Error", "Please enter all values");
                    return;


                }
                db.execSQL("INSERT INTO user VALUES('" + country.getText() + "','" +rooms.getText() + "','" + name.getText() + "','" + pasp.getText() + "','" +address.getText() + "','" + phone.getText() + "','" + email.getText() + "')");
                showMessage("SuccessFully ", "completed");
                clearText();
            }




            }


        private void clearText() {
           country.setText("");
            rooms.setText("");
            name.setText("");
            phone.setText("");
            pasp.setText("");
            address.setText("");
            email.setText("");
        }

        private void showMessage(String title, String message) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.show();


        }


    }

