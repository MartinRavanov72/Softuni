package spring_excr.services;

import spring_excr.models.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getAll();

    User getById(int id);

    List<User> findAllUsersWithSoldProducts();
}
