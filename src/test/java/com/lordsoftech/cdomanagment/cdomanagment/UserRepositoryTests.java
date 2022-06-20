package com.lordsoftech.cdomanagment.cdomanagment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.lordsoftech.cdomanagment.model.User;
import com.lordsoftech.cdomanagment.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("testingUser@test.com");
        user.setPassword(new BCryptPasswordEncoder().encode("blbeRandomHeslo"));

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertTrue(user.getEmail().equals(existUser.getEmail()));
        assertTrue(user.getPassword().equals(existUser.getPassword()));
        assertTrue(new BCryptPasswordEncoder().matches("blbeRandomHeslo", existUser.getPassword()));

    }

}
