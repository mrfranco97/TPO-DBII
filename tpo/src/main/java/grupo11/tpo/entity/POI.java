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
@Node("POI")
public class POI {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String description;
    private String location;

    public POI(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }
}
