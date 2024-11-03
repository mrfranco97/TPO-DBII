package grupo11.tpo.service;

import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.repository.HabitacionRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@EnableMongoRepositories
public class HabitacionService {

    @Setter
    @Getter
    private Set<Habitacion> habitaciones;

    @Autowired
    private HabitacionRepository habitacionRepo;

    public HabitacionService() {
        this.habitaciones = new HashSet<>();
    }

    public void guardarHabitacion(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
        this.habitacionRepo.save(habitacion);
    }

    public void eliminarHabitacion(Long id) {
        Habitacion habitacion = this.habitacionRepo.findById(id).orElse(null);
        if (habitacion != null) {
            this.habitaciones.remove(habitacion);
            this.habitacionRepo.delete(habitacion);
        }
    }

    public void actualizarDisponibilidad(Long id, boolean disponibilidad) {
        Habitacion habitacion = this.habitacionRepo.findById(id).orElse(null);
        if (habitacion != null) {
            habitacion.setDisponible(disponibilidad);
            this.habitacionRepo.save(habitacion);
        }
    }

    public List<Habitacion> buscarHabitacionesDisponibles(Date fechaInicio, Date fechaFin) {
        return this.habitacionRepo.buscarDisponiblesPorFechas(fechaInicio, fechaFin);
    }
}
