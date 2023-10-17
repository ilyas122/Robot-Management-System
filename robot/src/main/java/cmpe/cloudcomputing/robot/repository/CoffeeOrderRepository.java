package cmpe.cloudcomputing.robot.repository;

 
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cmpe.cloudcomputing.robot.entity.CoffeeOrder;

@Repository
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Integer>{
	
	@Query(value="SELECT * FROM coffee_order as c WHERE c.date >= ?1 AND c.date <= ?2 AND account=?3 ", nativeQuery = true)
	List<CoffeeOrder> findAllByDate(LocalDate start, LocalDate end, Integer account);

}
 