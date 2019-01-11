package com.example.lenovo.ratemysignings;

public class ListItem {
    private String user, name, age;

    public ListItem() {
    }

    public ListItem(String user, String name, String age) {
        this.user = user;
        this.name = name;
        this.age = age;
    }

    public String getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
};