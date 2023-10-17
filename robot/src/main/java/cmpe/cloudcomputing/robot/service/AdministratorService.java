package cmpe.cloudcomputing.robot.service;

import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import cmpe.cloudcomputing.robot.entity.Administrator;
import cmpe.cloudcomputing.robot.exception.ApiRequestException;
import cmpe.cloudcomputing.robot.repository.AdministratorRepository;
import cmpe.cloudcomputing.robot.security.SecurityConfig;

@Service
public class AdministratorService {

	@Autowired
	private AdministratorRepository adminRepository;
	
	public AdministratorService(AdministratorRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	public Administrator register(Administrator admin) {
		if (adminRepository.findByEmail(admin.getEmail()).isPresent())
			throw new ApiRequestException("'This email already exist.");
		
		//Encrypt admin's password using BCrypt
		admin.setRole("ADMIN");
		admin.setUsername(admin.getEmail());
		BCryptPasswordEncoder bCryptPasswordEncoder =
				new BCryptPasswordEncoder(SecurityConfig.bCryptStrength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(admin.getPassword());
		admin.setPassword(encodedPassword);
		return adminRepository.save(admin);
	}
}


/*
 * throw new ApiRequestException("'This email already exist.");
 
 Client get response: 
{
    "message": "'This email already exist.",
    "status": 400,
    "timestamp": "2022-02-28T12:35:09.625167-08:00"
}
*/