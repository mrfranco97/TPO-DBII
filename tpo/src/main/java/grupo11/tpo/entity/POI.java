package grupo11.tpo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@NoArgsConstructor
@Node("POI")
public class POI {
    @Id
    private Long id;
    private String name;
    private String type;
    private String location;

    public POI(Long id, String name, String type, String location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
    }
}
