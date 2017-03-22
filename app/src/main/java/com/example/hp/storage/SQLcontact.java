package com.example.hp.storage;

/**
 * Created by HP on 21-03-2017.
 */

public class SQLcontact {

    int id;
    String name;
    String phone_number;

    public SQLcontact(int id, String name, String phone_number) {
        this.id=id;
        this.name=name;
        this.phone_number=phone_number;
    }

    public SQLcontact() {
        
    }

    public SQLcontact(String name, String phone_number) {
        this.name=name;
        this.phone_number=phone_number;

    }

    public SQLcontact(int id) {
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


}
