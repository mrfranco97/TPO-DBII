package grupo11.tpo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Habitacion")
public class Habitacion {
    @GeneratedValue
    @Id
    private Long id;

    @Relationship(type = "INCLUYE",direction = Relationship.Direction.OUTGOING)
    private Set<Amenity> amenities = new HashSet<>();

    private String tipo;


    public Habitacion(String tipo) {
        this.tipo = tipo;
    }

    public void agregarAmenity(Amenity amenity){
        this.amenities.add(amenity);
    }
}
