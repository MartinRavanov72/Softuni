package com.example.demo.models.dtos.binding.user;

import java.io.Serializable;

public class UserCreateBindingModel implements Serializable {

    private String firstName;
    private String lastName;
    private Integer age;

    public UserCreateBindingModel() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
