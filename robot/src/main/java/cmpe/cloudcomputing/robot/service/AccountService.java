package cmpe.cloudcomputing.robot.service;


import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import cmpe.cloudcomputing.robot.entity.Account; 
import cmpe.cloudcomputing.robot.repository.AccountRepository; 

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public Account register(Account account) {
		return accountRepository.save(account);
	}
}
