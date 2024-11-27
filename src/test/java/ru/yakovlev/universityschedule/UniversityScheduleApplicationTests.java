package ru.yakovlev.universityschedule;

import ru.yakovlev.universityschedule.model.User;
import ru.yakovlev.universityschedule.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UniversityScheduleApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserRegistration() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        user.setFaculty("Engineering");
        user.setCourse(1);
        user.setGroupNumber("101");

        userService.saveUser(user);

        User foundUser = userService.findByUsername("testuser");
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("testuser");
        assertThat(passwordEncoder.matches("password", foundUser.getPassword())).isTrue();
    }
}
