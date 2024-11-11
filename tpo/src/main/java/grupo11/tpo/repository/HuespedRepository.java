package grupo11.tpo.repository;

import grupo11.tpo.entity.Huesped;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface HuespedRepository extends MongoRepository<Huesped,String> {

    @Query("{mail:'?0'}")
    Huesped findHuespedByEmail(String mail);

}
