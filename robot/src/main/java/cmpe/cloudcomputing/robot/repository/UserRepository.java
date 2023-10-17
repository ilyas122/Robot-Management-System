package cmpe.cloudcomputing.robot.repository;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cmpe.cloudcomputing.robot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User as u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);
	
	@Cacheable
	@Query("SELECT c FROM User as c WHERE c.username = ?1")
	Optional<User> findByUsername(String username);
}
