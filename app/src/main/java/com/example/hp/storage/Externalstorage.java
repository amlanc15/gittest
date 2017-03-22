package com.example.hp.storage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Externalstorage extends AppCompatActivity {
    Button b1,b2;
    EditText et1,et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externalstorage);
        b1=(Button)findViewById(R.id.save);
        b2=(Button)findViewById(R.id.read);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filenme=et1.getText().toString();
                String filedata= et2.getText().toString();
                try {
                    File myfile = new File("/sdcard/"+filenme);
                    myfile.createNewFile();
                    FileOutputStream fout= new FileOutputStream(myfile);
                    OutputStreamWriter mywriter =new OutputStreamWriter(fout);
                    mywriter.append(filedata);
                    mywriter.close();
                    fout.close();
                    Toast.makeText(Externalstorage.this,filenme+" saved",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = et1.getText().toString();
                String adatarow = "",abuffer="";
                try{
                    File myfile =new File("/sdcard/"+filename);
                    FileInputStream fio = new FileInputStream(myfile);
                    BufferedReader myreader= new BufferedReader(new InputStreamReader(fio));
                    while ((adatarow=myreader.readLine()) !=null){
                        abuffer += adatarow+"\n";
                    }
                    myreader.close();
                    Toast.makeText(Externalstorage.this,abuffer, Toast.LENGTH_SHORT).show();
                }
                catch (IOException e){
                    e.printStackTrace();
                }


            }
        });

    }
}
