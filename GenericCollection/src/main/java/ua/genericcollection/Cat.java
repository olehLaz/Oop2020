package ua.genericcollection;

public class Cat  {
    private String name;
    private int age;
    private String color;
    private boolean sex;

    public Cat() {
    }

    public Cat(String name, int age, String color, boolean sex) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.sex = sex;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
