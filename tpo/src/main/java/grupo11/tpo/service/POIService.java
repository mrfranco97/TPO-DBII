package grupo11.tpo.service;

import grupo11.tpo.entity.POI;
import grupo11.tpo.repository.POIRepository;
import org.neo4j.cypherdsl.core.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class POIService {
    @Autowired
    private POIRepository poiRepository;

    public void guardarPOI(POI poi) {
        poiRepository.save(poi);
    }

    public POI buscarPOI(Long id) {
        Optional<POI> aux = poiRepository.findById(id);

        if (aux.isPresent()) {
            POI poi = aux.get();
            return poi;
        }
        return null;
    }

    public void modificarPoi(POI poi, String nombre) {
        poi.setName(nombre);
        poiRepository.save(poi);
        System.out.println("Se guardó correctamente");
    }

    public List<POI> obtenerPOIs() {
        return poiRepository.findAll();
    }

    // Método para eliminar un punto de interés por su ID
    public void eliminarPuntoDeInteres(Long id) {
        if (poiRepository.existsById(id)) { // Usa la instancia inyectada poiRepository
            System.out.println("Eliminando el punto de interés con ID: " + id);
            poiRepository.deleteById(id);
        } else {
            System.out.println("Punto de interés no encontrado con ID: " + id);
        }
    }
}
