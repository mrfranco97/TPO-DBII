package grupo11.tpo.repository;

import grupo11.tpo.entity.POI;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface POIRepository extends Neo4jRepository<POI, Long> {

    POI findByName(String name);

    @Query("MATCH (p:POI {name: $name}) DELETE p")
    void deleteByName(String name);

    @Query("MATCH (p:POI)-[:NEAR]-(h:Hotel {name: $hotelName}) RETURN p")
    List<POI> findPOIsNearHotel(String hotelName);
}
