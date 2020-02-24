package spotify.services.impl;

import org.springframework.web.client.HttpServerErrorException;
import spotify.repository.Customer;
import spotify.repository.CustomerRepository;
import spotify.repository.Song;
import spotify.repository.SongRepository;
import spotify.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final SongRepository songRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository, final SongRepository songRepository) throws HttpServerErrorException.InternalServerError {
        this.customerRepository = customerRepository;
        this.songRepository = songRepository;
    }

    @Override
    public void addCustomer(final Customer customer) {
        customerRepository.add(customer);
    }

    @Override
    public void deleteCustomer(final long id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer getCustomer(final long id) {
        return customerRepository.get(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public void update(final Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public String playSong(long id) {

        return "Playing song: " + songRepository.getTitle(id);
    }
}
