package spotify.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private SongRepository songRepository;

    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody final Customer customer) {
        repository.save(customer);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteCustomer(@PathVariable final long id) {
        repository.deleteById(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Customer> getCustomer(@PathVariable final long id)  {
        return repository.findById(id);
    };

    @GetMapping(value = "/get/all")
    public List<Customer> getAllCustomers() {
        return (List<Customer>) repository.findAll();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateCustomer(@PathVariable final long id, @RequestBody final Customer customer) {
        repository.updateCustomer(id, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getDateOfBirth(), customer.getIsPayed());
    };

    @GetMapping(value = "/play/{id}")
    public void playSong(@PathVariable final long id) {
        System.out.println("Playing song: " + songRepository.playSong(id) + " ...");
    }

}
