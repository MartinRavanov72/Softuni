package spring_excr.services;

import spring_excr.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    List<User> getAllUsersByEmailProvider(String provider);

    void deleteInactiveUsers(LocalDate date);

    void save(User user);
}
