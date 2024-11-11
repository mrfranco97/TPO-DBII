package grupo11.tpo.repository;

import grupo11.tpo.entity.Amenity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AmenityRepository extends Neo4jRepository<Amenity, Long> {
}
