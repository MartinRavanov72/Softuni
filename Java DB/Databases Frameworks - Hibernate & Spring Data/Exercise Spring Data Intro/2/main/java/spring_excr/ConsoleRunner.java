package spring_excr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_excr.models.User;
import spring_excr.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class ConsoleRunner implements CommandLineRunner{

    private UserService userService;

    @Autowired
    public ConsoleRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        insertUsers();
        deleteInactiveUsers(LocalDate.of(2015, 3, 3));
        printAllUsersByEmailProvider(scanner.readLine());
    }

    private void deleteInactiveUsers(LocalDate date) {
        this.userService.deleteInactiveUsers(date);
    }

    private void insertUsers() {
        User user = new User();
        user.setUsername("suraikata");
        user.setPassword("Tainoobichamazis66!!!");
        user.setEmail("azis@gmail.com");
        user.setAge(18);
        user.setLastTimeLoggedIn(LocalDateTime.of
                (LocalDate.of(2018, 3, 3),
                        LocalTime.of(3, 50)));
        this.userService.save(user);

        User user1 = new User();
        user1.setUsername("suraikataa");
        user1.setPassword("Tainoobichamazis66!!!1");
        user1.setEmail("azis1@gmail.com");
        user1.setAge(118);
        user1.setLastTimeLoggedIn(LocalDateTime.of
                (LocalDate.of(2016, 3, 3),
                        LocalTime.of(3, 50)));
        this.userService.save(user1);
    }

    private void printAllUsersByEmailProvider(String provider) {
        for (User user : this.userService.getAllUsersByEmailProvider(provider)) {
            System.out.println(user.getUsername()+ " " + user.getEmail());
        }
    }
}