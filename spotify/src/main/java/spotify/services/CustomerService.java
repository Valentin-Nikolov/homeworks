package spotify.services;

import spotify.repository.Customer;
import spotify.repository.Song;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    void deleteCustomer(long id);

    Customer getCustomer(long id);

    List<Customer> getAllCustomers();

    void update(Customer customer);

    String playSong(long id);
}
