package grupo11.tpo.repository;

import grupo11.tpo.entity.Hotel;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface HotelRepository extends Neo4jRepository<Hotel, Long> {
    @Query("MATCH (h:Hotel)-[r1:POSEE]->(hab:Habitacion) WHERE id(h) = $hotelId WITH hab, r1 OPTIONAL MATCH (hab)-[r2:INCLUYE]->(amenity:Amenity) DELETE r2, r1, hab;")
    void eliminarHabitacionesYRelaciones(Long hotelId);

}
