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
    private int capacidad;
    private boolean disponible;

    public Habitacion(String tipo, int capacidad, boolean disponible) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }
}
