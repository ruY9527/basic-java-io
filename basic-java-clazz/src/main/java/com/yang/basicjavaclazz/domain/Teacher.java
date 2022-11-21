package com.yang.basicjavaclazz.domain;

public class Teacher {

    public String name;
    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void say(){
        System.out.println("I'm a teacher");
    }

}
