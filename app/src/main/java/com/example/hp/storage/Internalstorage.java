package com.example.hp.storage;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Internalstorage extends AppCompatActivity {
    Button b1,b2;
    EditText e1,e2;
    String fname,fdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button5);
        e1=(EditText)findViewById(R.id.edit1);
        e2=(EditText)findViewById(R.id.edit2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname=e1.getText().toString();
                fdata=e2.getText().toString();
                try{ FileOutputStream fs;
                    fs= openFileOutput(fname,Context.MODE_PRIVATE);
                    fs.write(fdata.getBytes());
                    fs.close();
                    Toast.makeText(Internalstorage.this,fname+"save",Toast.LENGTH_SHORT).show();

                }
                catch (IOException ignored){

                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filenmae = e1.getText().toString();
                StringBuffer buffer= new StringBuffer();
                try {
                    BufferedReader inputreader =new BufferedReader(new InputStreamReader(openFileInput(filenmae)));
                    String inputstring;
                    while ((inputstring = inputreader.readLine()) !=null){
                        buffer.append(inputstring+"\n");
                    }
                    Toast.makeText(Internalstorage.this,buffer.toString(),Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

    }
}
