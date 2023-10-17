package cmpe.cloudcomputing.robot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cmpe.cloudcomputing.robot.entity.Robot;

@Repository
public interface RobotRepository extends JpaRepository<Robot, Integer>{
	
	@Query(value="SELECT * FROM Robot as r WHERE r.account = ?1", nativeQuery = true)
	List<Robot> findAllByAccount(Integer account);

	@Query(value="SELECT * FROM Robot as r WHERE r.account = ?1 AND r.status = \"ENABLED\"", nativeQuery = true)
	List<Robot> findEnabledByAccount(Integer account);

	@Query(value="SELECT * FROM Robot as r WHERE r.status = \"ENABLED\"", nativeQuery = true)
	List<Robot> findEnabledRobots();

	
	@Transactional
    @Modifying
	@Query("UPDATE Robot r SET r.status=?2 WHERE r.id = ?1")
	void updateRobotStatus(Integer id, String status);
}
