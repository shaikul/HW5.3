package com.example.myapplication23;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String surname;

    public User(String n,String s){
        name = n;
        surname = s;
    }

}
