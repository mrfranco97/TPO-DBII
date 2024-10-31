package grupo11.tpo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

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

    public Hotel(String nombre, String direccion, String telefono, String correo, String ubicacion) {
        this.name = nombre;
        this.address = direccion;
        this.phone = telefono;
        this.mail = correo;
        this.location = ubicacion;
    }

}
