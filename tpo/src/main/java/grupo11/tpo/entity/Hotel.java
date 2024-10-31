package grupo11.tpo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@NoArgsConstructor
@Node("Hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String ubicacion;

    public Hotel(String theContinental, String s, String mail, String paternal) {
    }
}
