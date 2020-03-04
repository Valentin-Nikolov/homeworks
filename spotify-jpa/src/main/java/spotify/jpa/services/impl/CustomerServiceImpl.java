package spotify.jpa.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spotify.jpa.entities.Customer;
import spotify.jpa.repositories.CustomerRepository;
import spotify.jpa.repositories.SongRepository;
import spotify.jpa.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private SongRepository songRepository;

    public CustomerServiceImpl(CustomerRepository repository, SongRepository songRepository) {
        this.repository = repository;
        this.songRepository = songRepository;
    }

    @Override
    public void addCustomer(final Customer customer) {
        repository.save(customer);
    }

    @Override
    public void deleteCustomer(final long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomer(final long id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) repository.findAll();
    }

    @Override
    public void updateCustomer(final long id, final Customer customer) {
        repository.updateCustomer(id, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getDateOfBirth(), customer.getIsPayed());
    }

    @Override
    public void playSong(final long id) {
        System.out.println("Playing song: " + songRepository.playSong(id) + " ...");
    }
}
