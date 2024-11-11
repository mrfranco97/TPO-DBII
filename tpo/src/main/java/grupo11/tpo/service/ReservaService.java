package grupo11.tpo.service;

import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HabitacionRepository;
import grupo11.tpo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@EnableMongoRepositories
public class ReservaService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservaRepository reservaRepo;

    public Huesped obtenerReservaporID(int id) {
        System.out.println("Obteniendo detalles de Reserva Nº" + id);
        return reservaRepo.findReservaById(id);
    }

    public List<Reserva> buscarReservaPorFecha(LocalDate fecha_inicio){
        System.out.println("Buscando reservas por la fecha ingresada: " + fecha_inicio);
        return findReservesByDate(fecha_inicio);
    }

    // Método para buscar habitaciones disponibles en un rango de fechas
    public List<Habitacion> buscarHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesDisponibles = habitacionRepository.findAll();  // Trae todas las habitaciones
        for (Habitacion habitacion : habitacionesDisponibles) {
            // Verificar si hay reservas que solapan las fechas
            List<Reserva> reservas = reservaRepository.findReservasPorRangoDeFechas(habitacion.getId(), fechaInicio, fechaFin);
            if (!reservas.isEmpty()) {
                // Si hay reservas que solapan, eliminar la habitación de la lista de disponibles
                habitacionesDisponibles.remove(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    // Método para obtener reservas hechas en una fecha específica
    public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
        System.out.println("Buscando reservas para la fecha: " + fecha);
        return reservaRepo.findReservesByDate(fecha);  // Llama al método del repositorio con la fecha
    }
}
