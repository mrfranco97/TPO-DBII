package grupo11.tpo.service;

import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.entity.Huesped;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HabitacionRepository;
import grupo11.tpo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
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
    @Autowired
    private HuespedRepository huespedRepo;

    public void guardarReserva(String huespedId, Reserva nuevaReserva) {
        Optional<Huesped> optionalHuesped = huespedRepo.findById(huespedId);
        if (optionalHuesped.isPresent()) {
            // Reserva reserva = optionalHuesped.get();
            // huesped.addReserva(nuevaReserva);
            reservaRepo.save(nuevaReserva);
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("No existe huesped con ese ID");
        }
    }

    public Reserva obtenerReservaPorID(String id) {
        System.out.println("Obteniendo detalles de Reserva Nº" + id);
        return reservaRepo.findReservaById(id);
    }

    public List<Reserva> buscarReservaPorFecha(LocalDate fecha_inicio){
        System.out.println("Buscando reservas por la fecha ingresada: " + fecha_inicio);
        return reservaRepo.findReservesByDate(fecha_inicio);
    }


    // Método para buscar habitaciones disponibles en un rango de fechas
    public List<Habitacion> buscarHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesDisponibles = habitacionRepository.findAll();  // Trae todas las habitaciones
        for (Habitacion habitacion : habitacionesDisponibles) {
            // Verificar si hay reservas que solapan las fechas
            List<Reserva> reservas = reservaRepo.findReservasPorRangoDeFechas(habitacion.getId(), fechaInicio, fechaFin);
            if (!reservas.isEmpty()) {
                // Si hay reservas que solapan, eliminar la habitación de la lista de disponibles
                habitacionesDisponibles.remove(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public List<Reserva> buscarReservasPorHuesped(String huespedId) {
        System.out.println("Obteniendo reservas para el huésped con ID: " + huespedId);
        return reservaRepo.findReservasPorHuespedId(huespedId);
    }

}
