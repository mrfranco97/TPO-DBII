package grupo11.tpo.repository;

import grupo11.tpo.entity.Hotel;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface HotelRepository extends Neo4jRepository<Hotel, Long> {
    @Query("MATCH (h:Hotel)-[r:POSEE]->(habitacion:Habitacion) WHERE id(h) = $hotelId DELETE r, habitacion")
    void eliminarHabitacionesYRelaciones(Long hotelId);

}
