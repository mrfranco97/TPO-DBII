package grupo11.tpo.repository;

import grupo11.tpo.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepository extends MongoRepository<Reserva,String> {

    @Query("{id:'?0'}")
    Huesped findReservaById(int id);

    @Query("{fecha_inicio:'?0'}")
    List findReservesByDate(LocalDate fecha_inicio); //Traer las reservas por fecha de reserva en el hotel 

}
