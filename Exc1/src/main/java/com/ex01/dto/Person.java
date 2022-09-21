package com.ex01.dto;

public class Person {
    private int id;
    private String fullname;
    private int age;
    private float salario;

    public Person() {
    }

    public Person(int id, String fullname, int age) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
