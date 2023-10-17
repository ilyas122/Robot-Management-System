package cmpe.cloudcomputing.robot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cmpe.cloudcomputing.robot.entity.Robot;
import cmpe.cloudcomputing.robot.service.RobotService;

@RestController
public class RobotController {
	
	@Autowired
	RobotService robotservice;

	
	//for Business User to register robot
	@PostMapping("/robot/register")
	public Robot registerRobot(@RequestBody Robot robot) {
		return robotservice.registerRobot(robot);
	}

	@GetMapping("/robot/getAllbyAccount/{account}")
	public List<Robot> findAllByUser(@PathVariable int account) {
		return robotservice.findAllByAccount(account);
	}
	
	@PostMapping("/robot/updatestatus")
	public void updateStatus(@RequestBody Robot robot) {
		robotservice.updateStatus(robot);
	}
	
	
	/*@DeleteMapping("/api/robot/delete")
	public Integer unRegisterRobot(@RequestBody Robot robot) {
		return robotservice.unRegisterRobot();
	}

	@GetMapping("/api/robot/allByUser/{id}")
	public List<Robot> findAllByUser(@PathVariable int id) {
		return robotservice.findAllByUser(id);
	}
    
    @PostMapping("/api/robot/order")
	public boolean order(@RequestBody OrderRecord order) {
    	System.out.println("Order CALL FROM Client");
    	return robotservice.order(order);
	}
    
    @PostMapping("/api/robot/completed/{id}")
	public void orderCompleted(@PathVariable int id) {
    	robotservice.orderCompleted(id);
	}
	*/
	
    @GetMapping("/robot/all")
	public List<Robot> findAll() {
		return robotservice.findAll();
	}
}
