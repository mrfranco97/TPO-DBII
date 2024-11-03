package grupo11.tpo.repository;

import grupo11.tpo.entity.Habitacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HabitacionRepository extends MongoRepository<Habitacion, Long> {

    @Query("{ 'disponible': true, 'reservas': { $not: { $elemMatch: { 'fechaInicio': { $lt: ?1 }, 'fechaFin': { $gt: ?0 } } } } }")
    List<Habitacion> buscarDisponiblesPorFechas(Date fechaInicio, Date fechaFin);
}
