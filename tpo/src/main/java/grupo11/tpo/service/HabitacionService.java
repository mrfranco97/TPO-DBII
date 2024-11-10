package grupo11.tpo.service;

import grupo11.tpo.entity.Amenity;
import grupo11.tpo.entity.Habitacion;
import grupo11.tpo.repository.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HabitacionService {
    @Autowired
    private HabitacionRepository habitacionRepo;

    public void guardarHabitacion(Habitacion habitacion) {
        habitacionRepo.save(habitacion);
        System.out.println("Habitación guardada correctamente.");
    }

    public void eliminarHabitacion(Long id) {
        habitacionRepo.deleteById(id);
    }


    public Optional<Habitacion> modificarHabitacion(Long id, String tipo) {
        Optional<Habitacion> optionalHabitacion = habitacionRepo.findById(id);
        optionalHabitacion.ifPresent(habitacion -> {
            habitacion.setTipo(tipo);
            habitacionRepo.save(habitacion);
        });
        return optionalHabitacion;
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
}
