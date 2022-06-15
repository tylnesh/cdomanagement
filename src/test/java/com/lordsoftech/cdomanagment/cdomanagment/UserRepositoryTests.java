package com.lordsoftech.cdomanagment.cdomanagment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
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
        user.setSalt(user.generateHashSalt());
        try {
            user.setPasswordHashed(user.hashPassword("randomBsPassword", user.getSalt()));
            System.out.println(user.getPasswordHashed());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assertTrue(user.getEmail().equals(existUser.getEmail()));
        assertTrue(user.getPasswordHashed().equals(existUser.getPasswordHashed()));
        try {
            assertTrue(
                    user.getPasswordHashed().equals(existUser.getPasswordHashed()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
