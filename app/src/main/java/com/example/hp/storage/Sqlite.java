package com.example.hp.storage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Sqlite extends AppCompatActivity {
    EditText name,phone,id;
    Button add,update,display,displayp,delete;
    TextView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        final SQLDatabaseHandler db = new SQLDatabaseHandler(this);
        view=(TextView)findViewById(R.id.displayview);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.phone);
        id=(EditText)findViewById(R.id.id);
        add=(Button)findViewById(R.id.add);
        update=(Button)findViewById(R.id.up);
        display =(Button)findViewById(R.id.disp);
        displayp=(Button)findViewById(R.id.part);
        delete=(Button)findViewById(R.id.del);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new SQLcontact(name.getText().toString(),phone.getText().toString()));
                name.setText("");
                phone.setText("");


            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updatecontact(new  SQLcontact(Integer.parseInt(id.getText().toString()),
                        name.getText().toString(),phone.getText().toString()));
                name.setText("");
                phone.setText("");
                id.setText("");

            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<SQLcontact> contacts = db.getAllContacts();
                for (SQLcontact cn : contacts){
                    String log = "Id: "+ cn.getId()+" ,Name: "+ cn.getName()+" ,phone: "+ cn.getPhone_number();
                    view.setText(log);
                    Log.v("name",log);
                }

            }
        });
        displayp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLcontact cn = db.getContact(Integer.parseInt(id.getText().toString()));
                String log = "Id: "+cn.getId()+" ,Name: "+ cn.getName()+" ,phone: "+ cn.getPhone_number();
                view.setText(log);



            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteContact(new SQLcontact(Integer.parseInt(id.getText().toString())));
                id.setText("");

            }
        });
    }
}
