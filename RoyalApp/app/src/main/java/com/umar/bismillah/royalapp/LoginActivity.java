package com.umar.bismillah.royalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button Blogin;
    EditText editText,editText7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            editText=(EditText)findViewById(R.id.editText);
            editText7=(EditText)findViewById(R.id.editText7);
            Blogin=(Button)findViewById(R.id.btnlog);

            Blogin.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if (editText.getText().toString().equals("Admin")&& editText7.getText().toString().equals("abc"))
                    {
                        Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG );
                        Intent i = new Intent(LoginActivity.this,VewActivity.class);
                        startActivity(i);


                    }


                }


            });





        }

    }

