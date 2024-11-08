package grupo11.tpo.entity;

import grupo11.tpo.relations.SeEncuentraA;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Hotel")
public class Hotel {
    @GeneratedValue
    @Id
    private Long id;

    private String name;
    private String address;
    private String phone;
    private String mail;
    private String location;

    @Relationship(type = "SE_ENCUENTRA_A",direction = Relationship.Direction.OUTGOING)
    private List<SeEncuentraA> poiCercanos = new ArrayList<SeEncuentraA>();

    @Relationship(type = "POSEE",direction = Relationship.Direction.OUTGOING)
    private Set<Habitacion> habitaciones = new HashSet<>();

    public Hotel(String nombre, String direccion, String telefono, String correo, String ubicacion) {
        this.name = nombre;
        this.address = direccion;
        this.phone = telefono;
        this.mail = correo;
        this.location = ubicacion;
    }

    public void agregarPOI(SeEncuentraA poi){
        this.poiCercanos.add(poi);
    }

    public void agregarHabitacion(Habitacion habitacion){
        this.habitaciones.add(habitacion);
    }

}
