package spotify.jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spotify.jpa.entities.Customer;
import spotify.jpa.services.impl.CustomerServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/spotify-jpa/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }


    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody final Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping(value = "/del/{id}")
	public void deleteCustomer(@PathVariable final long id) {
        customerService.deleteCustomer(id);
    };

    @GetMapping(value = "/get/{id}")
	public Optional<Customer> getCustomer(@PathVariable final long id)  {
        return customerService.getCustomer(id);
    };

    @GetMapping(value = "/get/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping(value = "/edit/{id}")
	public void updateCustomer(@PathVariable final long id, @RequestBody final Customer customer) {
        customerService.updateCustomer(id, customer);
    };

    @GetMapping(value = "/play/{id}")
    public void playSong(@PathVariable final long id) {
        customerService.playSong(id);
    }

}
