package cmpe.cloudcomputing.robot.service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cmpe.cloudcomputing.robot.entity.Account;
import cmpe.cloudcomputing.robot.entity.CoffeeOrder;
import cmpe.cloudcomputing.robot.entity.Customer;
import cmpe.cloudcomputing.robot.entity.Robot;
import cmpe.cloudcomputing.robot.exception.ApiRequestException;
import cmpe.cloudcomputing.robot.repository.AccountRepository;
import cmpe.cloudcomputing.robot.repository.CoffeeOrderRepository;
import cmpe.cloudcomputing.robot.repository.CustomerRepository;
import cmpe.cloudcomputing.robot.repository.RobotRepository;
import cmpe.cloudcomputing.robot.security.SecurityConfig;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CoffeeOrderRepository coffeeorderRepository;
	@Autowired
	private RobotRepository robotRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public Customer register(Customer customer) {
		if (customerRepository.findByEmail(customer.getEmail()).isPresent())
			throw new ApiRequestException("'This email already exist.");
		
		//Encrypt customer's password using BCrypt
		customer.setRole("CUSTOMER");
		customer.setUsername(customer.getEmail());
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder(SecurityConfig.bCryptStrength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPassword);
		return customerRepository.save(customer);
	}
	
	public String getLocations() {
		List<Account> list = accountRepository.findAll();
		String str = "[";
		
		for (int i=0; i<list.size(); i++) {
			List<Robot> robots = robotRepository.findEnabledByAccount(list.get(i).getId());
			if (robots.isEmpty()) continue;

			str += list.get(i).getLocation();
			str += ", ";
		};
		StringBuilder ret = new StringBuilder(str);
        ret.setCharAt(str.length()-2, ']');
        
        return ret.toString();
	}
	
	public CoffeeOrder makeCoffee(CoffeeOrder order) {
		System.out.println("LOG makeCoffee");

		System.out.println(order.getAccount());
		
		List<Robot> list = robotRepository.findEnabledByAccount(order.getAccount());
		if (list.isEmpty())
			throw new ApiRequestException("no robots");
		
		
		//ADD MORE order_state
		//If robot is busy, ask another robot. So need to check status ?
		/*for(Robot r : list) {
			r.getStatus()
		}
		*/
		Robot robot = list.get(0);
		
		order.setState("ORDERED");
		order.setRobotId(robot.getId());
		order.setDate(LocalDate.now());
		return coffeeorderRepository.save(order);
	}
}
