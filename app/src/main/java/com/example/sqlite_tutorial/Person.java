package com.example.sqlite_tutorial;

public class Person {


    private String name;
    private int age;
    private boolean is_active;

    public Person(String name, int age, boolean is_active) {
        this.name = name;
        this.age = age;
        this.is_active = is_active;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", is_active=" + is_active +
                '}';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

}
