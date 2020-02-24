package spotify.rest;

import org.springframework.web.bind.annotation.*;
import spotify.repository.Customer;
import spotify.repository.Song;
import spotify.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/spotify/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody final Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable final long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable final long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/get/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/edit")
    public void updateArtist(@RequestBody final Customer customer) {
        customerService.update(customer);
    }

    @GetMapping("/play/{id}")
    public String playSong(@PathVariable final long id) {
        return customerService.playSong(id);
    }
}
