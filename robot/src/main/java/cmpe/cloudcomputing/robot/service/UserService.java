package cmpe.cloudcomputing.robot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import cmpe.cloudcomputing.robot.entity.User;
import cmpe.cloudcomputing.robot.exception.ApiRequestException;
import cmpe.cloudcomputing.robot.repository.UserRepository;
import cmpe.cloudcomputing.robot.repository.RecordRepository;
import cmpe.cloudcomputing.robot.document.RobotRecord;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepository;
	
	@Autowired
	private RecordRepository recordrepository;
	
	public UserService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	@Transactional
	public User createUser(User user) {
		if (userrepository.findByEmail(user.getEmail()).isPresent())
			throw new ApiRequestException("This email is already registed.");
		return userrepository.save(user);
	}
	
	public boolean login(User user) {
		Optional<User> find = userrepository.findByEmail(user.getEmail());
		return find.get().getPassword().equals(user.getPassword());
	}

	public List<User> findAll() {
		return userrepository.findAll();
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
