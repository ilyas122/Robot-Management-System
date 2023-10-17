package cmpe.cloudcomputing.robot.controller;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import cmpe.cloudcomputing.robot.entity.CoffeeOrder;
import cmpe.cloudcomputing.robot.entity.Customer; 
import cmpe.cloudcomputing.robot.service.CustomerService;

@RestController
public class CustomerController { 

	@Autowired
	CustomerService customerService;
	
	//register new customer ->name/password/email
	@PostMapping("/customer/register")
	public Customer register(@RequestBody Customer customer) {
		return customerService.register(customer);
	}
	
	
	@GetMapping("/customer/locations")
	public String getLocations() {
		return customerService.getLocations();
	}
	
	@PostMapping("/customer/makecoffee")
	public CoffeeOrder register(@RequestBody CoffeeOrder order) {
		 return customerService.makeCoffee(order);
	}
}
