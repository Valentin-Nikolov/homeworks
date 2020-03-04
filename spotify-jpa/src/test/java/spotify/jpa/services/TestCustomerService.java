package spotify.jpa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import spotify.jpa.entities.Customer;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("test")
public class TestCustomerService {

    @Autowired
    CustomerService customerService;

    @Test
    public void createCustomer() {

        Customer customer = new Customer();

        customer.setFirstName("Valentin");
        customer.setLastName("Nikolov");
        customer.setEmail("valko@abv.bg");
        customer.setDateOfBirth(new Date());
        customer.setIsPayed(true);

        customerService.addCustomer(customer);

        assertEquals("Valentin", customer.getFirstName());
        assertEquals("Nikolov", customer.getLastName());
        assertEquals("valko@abv.bg", customer.getEmail());
        assertEquals(true, customer.getIsPayed());
    }
}
