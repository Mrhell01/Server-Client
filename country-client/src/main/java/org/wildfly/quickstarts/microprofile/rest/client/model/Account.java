package org.wildfly.quickstarts.microprofile.rest.client.model;

public class Account {


    public String name;
    public int balance;
    public int id;

    public Account(){

    }
    public Account(String name , int balance,int id) {

        this.name = name;
        this.balance = balance;
        this.id = id;

    }



}


