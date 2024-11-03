package grupo11.tpo.service;

import grupo11.tpo.entity.POI;
import grupo11.tpo.repository.POIRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service
public class POIService {

    @Setter
    @Getter
    private Set<POI> pois;

    private final POIRepository poiRepo;

    public POIService(POIRepository poiRepo) {
        this.pois = new HashSet<>();
        this.poiRepo = poiRepo;
    }

    public void guardarPOI(POI poi) {
        this.pois.add(poi);
        this.poiRepo.save(poi);
    }

    public void eliminarPOIPorNombre(String name) {
        POI poi = this.poiRepo.findByName(name);
        if (poi != null) {
            this.pois.remove(poi);
            this.poiRepo.delete(poi);
        }
    }

    public List<POI> obtenerPOIsCercanosAHOTEL(String hotelName) {
        return this.poiRepo.findPOIsNearHotel(hotelName);
    }
}
