package cmpe.cloudcomputing.robot.service;

import java.util.List;

import javax.transaction.Transactional;

import cmpe.cloudcomputing.robot.document.RobotRecord;
import cmpe.cloudcomputing.robot.entity.Robot;
import cmpe.cloudcomputing.robot.exception.ApiRequestException;
import cmpe.cloudcomputing.robot.repository.AccountRepository;
import cmpe.cloudcomputing.robot.repository.RecordRepository;
import cmpe.cloudcomputing.robot.repository.RobotRepository;
import cmpe.cloudcomputing.robot.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {


	@Autowired
	RobotRepository robotrepository;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RecordRepository recordrepository;
	@Autowired
	AccountRepository accountrepository;

	public Robot registerRobot(Robot robot) {
		if (!accountrepository.findById(robot.getAccount()).isPresent())
			throw new ApiRequestException("'invalid account");

		robot.setStatus("ENABLED");
		return robotrepository.save(robot);
	}
	
	public void updateStatus(Robot robot) {
		if (!robotrepository.findById(robot.getId()).isPresent())
			throw new ApiRequestException("'invalid robot id");
		
		robotrepository.updateRobotStatus(robot.getId(), robot.getStatus());
		
		//ADD ROBOT API
		
	}
	
	//User request Terminate Robot:
	public void unRegisterRobot(int id) {
		// add CODE:
		// end time is here, calculate Usage time
		robotrepository.deleteById(id);
	}
	
	public List<Robot> findAll() {
		return robotrepository.findAll();
	}
	
	/*public List<Robot> findAllByUserId(Integer userid) {
		String role = userrepository.findById(userid).get().getRole();
		if (!role.equals("ADMIN"))
			new Api
		return robotrepository.findAll();
	}*/	

	public List<Robot> findAllByAccount(Integer account) {
		return robotrepository.findAllByAccount(account);
	}
	
	public void orderCompleted(Integer id) {
		//robotrepository.updateRobotStatus(id, "CONNECTED");
	}
	
	//TEST CODE
	@Transactional
	public void testMongo() {
		recordrepository.save(new RobotRecord("NameRobotOne", "StatusActive"));
		recordrepository.save(new RobotRecord("NameRoBotTwo", "StatusConnected"));
		List<RobotRecord> list =  recordrepository.findAll();
		list.forEach(System.out::println);
	}
}
