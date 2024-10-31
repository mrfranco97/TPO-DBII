package grupo11.tpo.repository;

import grupo11.tpo.entity.Hotel;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HotelRepository extends Neo4jRepository<Hotel, Long> {
}
