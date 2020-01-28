package ua.homestudents;

import java.io.Serializable;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String surname;
    private String name;

    public Human(int age, String surname, String name) {
        super();
        this.age = age;
        this.surname = surname;
        this.name = name;
    }

    public Human() {
        super();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human [age=" + age + ", surname=" + surname + ", name=" + name + "]";
    }
}
