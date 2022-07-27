package com.lordsoftech.cdomanagment.cdomanagment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.lordsoftech.cdomanagment.model.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.lordsoftech.cdomanagment.repository.AppUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AppAppUserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AppUserRepository repo;

    @Test
    public void testCreateUser() {
        AppUser appUser = new AppUser();
        appUser.setEmail("testingUser@test.com");
        appUser.setPassword(new BCryptPasswordEncoder().encode("blbeRandomHeslo"));

        AppUser savedAppUser = repo.save(appUser);
        AppUser existAppUser = entityManager.find(AppUser.class, savedAppUser.getId());

        assertTrue(appUser.getEmail().equals(existAppUser.getEmail()));
        assertTrue(appUser.getPassword().equals(existAppUser.getPassword()));
        assertTrue(new BCryptPasswordEncoder().matches("blbeRandomHeslo", existAppUser.getPassword()));

    }

}
