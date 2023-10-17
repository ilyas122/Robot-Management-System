package cmpe.cloudcomputing.robot.repository;

import cmpe.cloudcomputing.robot.document.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<Record, String> {
}
