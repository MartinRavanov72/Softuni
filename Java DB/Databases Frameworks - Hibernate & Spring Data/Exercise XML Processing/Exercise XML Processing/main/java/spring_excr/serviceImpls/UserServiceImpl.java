package spring_excr.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_excr.models.User;
import spring_excr.repositories.UserRepository;
import spring_excr.services.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsersWithSoldProducts() {
        return this.userRepository.findAllUsersWithSolldProducts();
    }
}
