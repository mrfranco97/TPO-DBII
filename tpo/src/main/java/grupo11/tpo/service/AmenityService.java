package grupo11.tpo.service;

import grupo11.tpo.entity.Amenity;
import grupo11.tpo.repository.AmenityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AmenityService {
    @Autowired
    private AmenityRepository amenityRepo;

    public void guardarAmenity(Amenity amenity) {
        amenityRepo.save(amenity);
        System.out.println("Amenity agregado correctamente.");
    }

    public void eliminarAmenity(String name) {
        amenityRepo.deleteByName(name);
    }

    public Optional<Amenity> modificarAmenity(Long id, String name, String description) {
        Optional<Amenity> optionalAmenity = amenityRepo.findById(id);
        optionalAmenity.ifPresent(amenity -> {
            amenity.setName(name);
            amenity.setDescription(description);
            amenityRepo.save(amenity);
        });
        return optionalAmenity;
    }
}
