package spotify.jpa.services;

import spotify.jpa.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    void addCustomer(final Customer customer);

    void deleteCustomer(final long id);

    Optional<Customer> getCustomer(final long id);

    List<Customer> getAllCustomers();

    void updateCustomer(final long id, final Customer customer);

    void playSong(final long id);
}
