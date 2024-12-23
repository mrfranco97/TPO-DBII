package grupo11.tpo.service;

import grupo11.tpo.entity.Amenity;
import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.entity.Reserva;
import grupo11.tpo.repository.HabitacionRepository;
import grupo11.tpo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepo;

    @Autowired
    private ReservaRepository reservaRepo;  // Repositorio de reservas para consultar disponibilidad

    public void guardarHabitacion(Habitacion habitacion) {
        habitacionRepo.save(habitacion);
        System.out.println("Habitación guardada correctamente.");
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepo.deleteById(id);
        System.out.println("Se elimino satisfactoriamente.");
    }


    public void modificarHabitacion(Habitacion habitacion, String tipo) {
        habitacion.setTipo(tipo);
        habitacionRepo.save(habitacion);
    }

    public void agregarAmenity(Habitacion habitacion, Amenity amenity){
        habitacion.agregarAmenity(amenity);
        habitacionRepo.save(habitacion);
        System.out.println("Se guardo correctamente");
    }

    public Habitacion obtenerHabitacionporId(Long id){
        Optional<Habitacion> aux = habitacionRepo.findById(id);
        if(aux.isPresent()){
            return aux.get();
        }
        else {
            return null;
        }
    }

    // Nuevo método para buscar habitaciones disponibles en un rango de fechas
    public List<Habitacion> buscarHabitacionesDisponibles(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();
        List<Habitacion> todasLasHabitaciones = habitacionRepo.findAll();  // Trae todas las habitaciones

        for (Habitacion habitacion : todasLasHabitaciones) {
            // Buscar reservas de la habitación en el rango de fechas
            List<Reserva> reservas = reservaRepo.findReservasPorRangoDeFechas(habitacion.getId(), fechaInicio, fechaFin);
            if (reservas.isEmpty()) {
                // Si no hay reservas en ese rango, la habitación está disponible
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }
}
