package grupo11.tpo.repository;

import grupo11.tpo.entity.Habitacion;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitacionRepository extends Neo4jRepository<Habitacion, Long> {
}
