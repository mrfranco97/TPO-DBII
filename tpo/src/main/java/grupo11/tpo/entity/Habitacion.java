package grupo11.tpo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document("Habitacion")  // Almacenado en MongoDB
public class Habitacion {
    private Long id;  // Identificador único
    private String tipo;  // Tipo de habitación
    private int capacidad;  // Capacidad de la habitación
    private List<Amenity> amenities = new ArrayList<>();  // Lista de amenities
    private boolean disponible = true;  // Disponibilidad

    public Habitacion(Long id, String tipo, int capacidad, List<Amenity> amenities, boolean disponible) {
        this.id = id;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.amenities = amenities;
        this.disponible = disponible;
    }

    public void agregarAmenity(Amenity amenity) {
        if (!this.amenities.contains(amenity)) {
            this.amenities.add(amenity);
        }
    }

    public void removerAmenity(Amenity amenity) {
        this.amenities.remove(amenity);
    }

    public void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }
}
