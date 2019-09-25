package com.example.demo.services.user;

import com.example.demo.models.dtos.binding.user.UserCreateBindingModel;

import java.util.Collection;

public interface UserService {

    void save(UserCreateBindingModel model);

    void save(Collection<UserCreateBindingModel> models);
}