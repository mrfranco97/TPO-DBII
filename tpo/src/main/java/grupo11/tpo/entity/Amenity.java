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
@Node("Amenity")
public class Amenity {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String description;

    public Amenity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
