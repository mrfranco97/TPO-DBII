package grupo11.tpo.repository;

import grupo11.tpo.entity.Amenity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AmenityRepository extends MongoRepository<Amenity, String> {
    Amenity findByName(String name);
    void deleteByName(String name);
}
