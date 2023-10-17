package cmpe.cloudcomputing.robot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cmpe.cloudcomputing.robot.entity.User;

@Repository
public interface CustomerRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM Customer as u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);

}
