package model;

import androidx.annotation.NonNull;

public class Pet {
    String name, breed;
    int age;



    public Pet(String name, String breed,int age) {
        this.age = age;
        this.name = name;
        this.breed = breed;
    }


    @Override
    public String toString() {
        return name + "(" + breed + "):" + age;
    }

    public Pet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
