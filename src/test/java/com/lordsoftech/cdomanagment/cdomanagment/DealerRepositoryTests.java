package com.lordsoftech.cdomanagment.cdomanagment;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.lordsoftech.cdomanagment.model.Dealer;
import com.lordsoftech.cdomanagment.repository.DealerRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DealerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private DealerRepository repo;

    @Test
    public void testCreateDealer() {
        Dealer dealer = new Dealer();
        dealer.setDealer("testDealer");
        dealer.setSlug("td");
        Dealer savedDealer = repo.save(dealer);
        Dealer existDealer = entityManager.find(Dealer.class, savedDealer.getId());
        assertTrue(dealer.getDealer().equals(existDealer.getDealer()));
        assertTrue(dealer.getSlug().equals(existDealer.getSlug()));
    }

}
