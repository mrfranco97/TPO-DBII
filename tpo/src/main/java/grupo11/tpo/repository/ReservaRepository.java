package grupo11.tpo.repository;

import grupo11.tpo.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HuespedRepository extends MongoRepository<Reserva,String> {

    @Query("{id:'?0'}")
    Huesped findReservaById(int id);

}
