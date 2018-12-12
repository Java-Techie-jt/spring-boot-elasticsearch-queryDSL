package com.javatechie.es.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.es.api.model.Customer;
import com.javatechie.es.api.repository.CustomerRepository;

@SpringBootApplication
@RestController
public class SpringBootElasticserachExampleApplication {
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/saveCustomer")
	public int saveCustomer(@RequestBody List<Customer> customers) {
		repository.save(customers);
		return customers.size();
	}

	@GetMapping("/findAll")
	public Iterable<Customer> findAllCustomers() {
		return repository.findAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<Customer> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstname(firstName);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticserachExampleApplication.class, args);
	}
}
