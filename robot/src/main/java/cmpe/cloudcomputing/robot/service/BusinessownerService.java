package cmpe.cloudcomputing.robot.service;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import cmpe.cloudcomputing.response.BusinessRegister;
import cmpe.cloudcomputing.response.DateAccount;
import cmpe.cloudcomputing.response.KeyValueType;
import cmpe.cloudcomputing.robot.entity.Account;
import cmpe.cloudcomputing.robot.entity.Businessowner;
import cmpe.cloudcomputing.robot.entity.CoffeeOrder;
import cmpe.cloudcomputing.robot.entity.User;
import cmpe.cloudcomputing.robot.exception.ApiRequestException;
import cmpe.cloudcomputing.robot.repository.AccountRepository;
import cmpe.cloudcomputing.robot.repository.BusinessownerRepository;
import cmpe.cloudcomputing.robot.repository.CoffeeOrderRepository;
import cmpe.cloudcomputing.robot.security.SecurityConfig;

@Service
public class BusinessownerService {

	@Autowired
	private BusinessownerRepository boRepository;
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountService accountservice;
	@Autowired
	private CoffeeOrderRepository cforepository;
	
	public BusinessownerService(BusinessownerRepository boRepository) {
		super();
		this.boRepository = boRepository;
	}
	
	public Businessowner register(BusinessRegister request) {
		if (boRepository.findByEmail(request.getEmail()).isPresent())
			throw new ApiRequestException("'This email already exist.");
		
		// ADD: how to find business duplication? 
		
		
		//one account can be shared to several business users
		Account account;
		
		//Case1: init 0 for invalid account 
		int account_id = 0;
		
		//Case2: already existed valid account
		if (request.getAccount()!=null||request.getAccount()!=0)
			account_id =  request.getAccount(); 

		//Case3: non existed account
		if (!accountRepository.findById(account_id).isPresent()) { 
			account = new Account(request.getBusinessname(), request.getAddress(), request.getCity(), request.getState(), request.getZip());
			account = accountservice.register(account);
			account_id = account.getId();
		}

		//create an business user
		Businessowner new_business = new Businessowner(request.getName(), 
				request.getEmail(), request.getPassword(), account_id);

		//ID&PW
		new_business.setUsername(request.getEmail());
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder(SecurityConfig.bCryptStrength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
		new_business.setPassword(encodedPassword);
		
		return boRepository.save(new_business);
	}

	//get account by business user id
	public int getAccount(int id) {
		Optional<User> instance = boRepository.findById(id);
		if (!instance.isPresent())
			throw new ApiRequestException("invalid id");

		Businessowner bo = (Businessowner) instance.get();
		return bo.getAccount();
	}
	
	public KeyValueType getTotalCountType(DateAccount date) {
		LocalDate d_start = LocalDate.parse(date.getStart());
		LocalDate d_end = LocalDate.parse(date.getEnd());

		List<CoffeeOrder> list = cforepository.findAllByDate(d_start, d_end, date.getAccount());
		HashMap<String, Integer> totalSales = new HashMap<String, Integer>();
		
		for	(CoffeeOrder order : list) {
			if (totalSales.get(order.getType())==null)
				totalSales.put(order.getType(), 1);
			else
				totalSales.put(order.getType(), totalSales.get(order.getType())+1);
		}		
		return new KeyValueType(totalSales.keySet(),totalSales.values());
	}

	
	public KeyValueType getInvoice(DateAccount date) {
		System.out.println("This Should be implemented");
		System.out.println(date.getStart());
		//LocalDate month = LocalDate.parse(date.getStart());
		
		
		Set<String> key = new HashSet<String>(){{
		    add("rent");
		    add("lease");
		}};
        List<Integer> values = Arrays.asList(200,300);

		return new KeyValueType(key, values);
		
	}
}
