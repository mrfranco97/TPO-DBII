package grupo11.tpo.service;

import grupo11.tpo.entity.POI;
import grupo11.tpo.repository.POIRepository;
import org.neo4j.cypherdsl.core.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class POIService {
    @Autowired
    private POIRepository poiRepository;

    public void guardarPOI(POI poi){
        poiRepository.save(poi);
    }

    public POI buscarPOI(Long id){
        Optional<POI> aux = poiRepository.findById(id);

        if (aux.isPresent()){
            POI poi = aux.get();
            return poi;
        }
        return null;
    }
}
