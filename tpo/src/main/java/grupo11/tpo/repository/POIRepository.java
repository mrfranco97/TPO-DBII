package grupo11.tpo.repository;

import grupo11.tpo.entity.POI;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface POIRepository extends Neo4jRepository<POI,Long> {
}
