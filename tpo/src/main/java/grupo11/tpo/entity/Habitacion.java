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
@Node("Habitacion")
public class Habitacion {
    @GeneratedValue
    @Id
    private Long id;
    private String tipo;


    public Habitacion(String tipo) {
        this.tipo = tipo;

    }
}
