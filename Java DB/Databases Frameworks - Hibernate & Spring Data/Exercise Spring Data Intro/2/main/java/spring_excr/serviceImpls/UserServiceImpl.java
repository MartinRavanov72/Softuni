package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.models.User;
import spring_excr.repositories.UserRepository;
import spring_excr.services.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsersByEmailProvider(String provider) {
        return this.userRepository.findAllByEmailEndingWith(provider);
    }

    @Override
    public void deleteInactiveUsers(LocalDate date) {
        List<User> inactiveUsers = userRepository.findAllByLastTimeLoggedInBefore(LocalDateTime.of(date,
                LocalTime.of(15, 15)));
        for (User user : inactiveUsers) {
            this.userRepository.delete(user);
        }
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }
}