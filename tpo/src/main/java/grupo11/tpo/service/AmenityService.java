package grupo11.tpo.service;

import grupo11.tpo.entity.Amenity;
import grupo11.tpo.repository.AmenityRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@EnableMongoRepositories
public class AmenityService {

    @Getter
    @Setter
    private Set<Amenity> amenities;

    private final AmenityRepository amenityRepo;

    public AmenityService(AmenityRepository amenityRepo) {
        this.amenities = new HashSet<>();
        this.amenityRepo = amenityRepo;
    }

    public void guardarAmenity(Amenity amenity) {
        this.amenities.add(amenity);
        this.amenityRepo.save(amenity);
    }

    public void eliminarAmenity(String name) {
        Amenity amenity = this.amenityRepo.findByName(name);
        if (amenity != null) {
            this.amenities.remove(amenity);
            this.amenityRepo.delete(amenity);
        }
    }

    public void actualizarAmenity(String name, String newDescription) {
        Amenity amenity = this.amenityRepo.findByName(name);
        if (amenity != null) {
            amenity.setDescription(newDescription);
            this.amenityRepo.save(amenity);
        }
    }

    public Optional<Amenity> obtenerAmenityPorNombre(String name) {
        return Optional.ofNullable(this.amenityRepo.findByName(name));
    }
}
