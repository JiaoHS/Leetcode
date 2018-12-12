package com.xjtu.ssmidea.domain;

public class Student {
    private Long Id;
    private String Name;

    public Student() {
        //no instance
    }

    public Student(String Name) {
        this.Name = Name;
    }
    public void setName(){
        Name=this.Name;
    }
    public String getName(){
        return Name;
    }
}
