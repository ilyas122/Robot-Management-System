package cmpe.cloudcomputing.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.cloudcomputing.robot.entity.Administrator;
import cmpe.cloudcomputing.robot.service.AdministratorService;
@RestController
public class AdministratorController {
	

	@Autowired
	AdministratorService adminService;
	
	//register new customer ->name/password/email
	@PostMapping("/admin/register")
	public Administrator register(@RequestBody Administrator admin) {
		return adminService.register(admin);
	}
	
	
}
