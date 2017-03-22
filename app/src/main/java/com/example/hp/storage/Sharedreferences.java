package com.example.hp.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sharedreferences extends AppCompatActivity {
    EditText e1,e2;
    Button save,read;
    SharedPreferences reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedreferences);
        save=(Button)findViewById(R.id.save);
        read=(Button)findViewById(R.id.read);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        reference = PreferenceManager.getDefaultSharedPreferences(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =e1.getText().toString();
                if(!text.isEmpty()){
                    reference.edit().putString("e2",text).apply();

                }
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text =reference.getString("e2","nothing found");
                e2.setText(text);
            }
        });

    }
}
