package grupo11.tpo.repository;

import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    // Método para obtener una reserva específica por su ID
    @Query("{'_id': ?0}")
    Reserva findReservaById(String _id);

    // Método para obtener reservas que empiezan en una fecha específica
    @Query("{ 'fecha_inicio': ?0 }")
    List<Reserva> findReservesByDate(LocalDate fecha);

    // Método para obtener reservas que se solapan con un rango de fechas para una habitación específica
    @Query("{ 'id_habitacion': ?0, 'fecha_inicio': { $lte: ?1 }, 'fecha_final': { $gte: ?2 } }")
    List<Reserva> findReservasPorRangoDeFechas(Long idHabitacion, LocalDate fecha_inicio, LocalDate fecha_final);

    // Método para obtener todas las reservas de un huésped específico
    @Query("{ 'huesped.id': ?0 }")
    List<Reserva> findReservasPorHuespedId(String huespedId);
}
