package grupo11.tpo.service;

import grupo11.tpo.entity.POI;
import grupo11.tpo.repository.POIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class POIService {

    @Autowired
    private POIRepository poiRepo;

    public List<POI> obtenerTodosLosPOIs() {
        return poiRepo.findAll();
    }

    public Optional<POI> obtenerPOIPorId(Long id) {
        return poiRepo.findById(id);
    }

    public void guardarPOI(POI poi) {
        poiRepo.save(poi);
        System.out.println("POI agregado correctamente.");
    }

    public Optional<POI> modificarPOI(Long id, String name, String description, String location) {
        Optional<POI> optionalPOI = poiRepo.findById(id);
        optionalPOI.ifPresent(poi -> {
            poi.setName(name);
            poi.setDescription(description);
            poi.setLocation(location);
            poiRepo.save(poi);
        });
        return optionalPOI;
    }

    public void eliminarPOI(Long id) {
        poiRepo.deleteById(id);
        System.out.println("POI eliminado correctamente.");
    }
}

