package grupo11.tpo.relations;

import grupo11.tpo.entity.POI;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
public class SeEncuentraA {
    @Id@GeneratedValue
    private Long id;

    private Double valor;

    @TargetNode
    private POI poi;

    public SeEncuentraA(POI poi,Double distancia){
        this.valor=distancia;
        this.poi=poi;

    }
}
