package grupo11.tpo.relations;

import grupo11.tpo.entity.POI;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class SeEncuentraA {
    @Id
    private Long id;

    private Double valor;

    @TargetNode
    private POI poi;

    public SeEncuentraA(POI poi, Double valor) {
        this.poi = poi;
        this.valor = valor;
    }
}
